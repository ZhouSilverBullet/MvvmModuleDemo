package com.zhousaito.mvvmmoduledemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.SmartRefreshLayout.setDefaultRefreshHeaderCreator
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlin.properties.Delegates
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
import com.scwang.smartrefresh.layout.SmartRefreshLayout.setDefaultRefreshFooterCreator
import com.zhousaito.base.BaseApplication


/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 12:03
 * Version: 1.0
 * Description:
 */
class App : BaseApplication() {

    companion object {
        //静态代码块
        init {
            setDefaultRefreshHeaderCreator { context, layout ->
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)
                ClassicsHeader(context)
            }

            setDefaultRefreshFooterCreator { context, layout ->
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter(context).setDrawableSize(20f)
            }
        }

        var INSTANCE: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }


}