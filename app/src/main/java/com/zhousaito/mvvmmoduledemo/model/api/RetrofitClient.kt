package com.zhousaito.mvvmmoduledemo.model.api

import com.zhousaito.common.api.BaseRetrofitClient
import com.zhousaito.common.utils.NetworkUtils
import com.zhousaito.mvvmmoduledemo.App
import com.zhousaito.mvvmmoduledemo.BuildConfig
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 16:57
 * Version: 1.0
 * Description:
 */
object RetrofitClient : BaseRetrofitClient() {
    val apiService by lazy {
        getService(ApiService::class.java, ApiService.BASE_URL)
    }

    override fun connectTimeOut(): Int {
        return 3
    }

    override fun isDebug(): Boolean = BuildConfig.DEBUG

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.readTimeout(3.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(3.toLong(), TimeUnit.SECONDS)

        val file = File(App.INSTANCE.cacheDir, "responses")
        val cacheSize = 10 * 1024 * 1024L;
        val cache = Cache(file, cacheSize)
        builder.cache(cache)
//                .cookieJar()
                .addInterceptor { chain ->
                    var request = chain.request()
                    //没有网的情况下，使用缓存
                    if (!NetworkUtils.isNetworkAvailable(App.INSTANCE)) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build()
                    }
                    val response = chain.proceed(request)

                    if (!NetworkUtils.isNetworkAvailable(App.INSTANCE)) {
                        val maxAge = 60 * 60;
                        response.newBuilder().removeHeader("Pragma")
                                .header("Cache-Control", "public, max-age=$maxAge")
                                .build()
                    } else {
                        val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale
                        response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                                .build()
                    }

                    response
                }
    }
//    companion object {

//        val retrofit by lazy {
//            Retrofit.Builder()
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .baseUrl(ApiService.BASE_URL)
//                    .build()
//        }

//        fun getApi(): ApiService {
//            return retrofit.create();
//        }
//    }


}