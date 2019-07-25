package com.zhousaito.mvvmmoduledemo.model.api

import com.zhousaito.mvvmmoduledemo.model.data.BannerData
import com.zhousaito.mvvmmoduledemo.model.data.BaseResponse
import com.zhousaito.mvvmmoduledemo.model.data.ChapterData
import retrofit2.http.GET

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 16:58
 * Version: 1.0
 * Description:
 */
interface ApiService {
    companion object {
        const val BASE_URL = "https://www.wanandroid.com/";
    }

    @GET("banner/json")
    suspend fun banner(): BaseResponse<List<BannerData>>

    @GET("wxarticle/chapters/json")
    suspend fun chapter(): BaseResponse<List<ChapterData>>
}