package com.zhousaito.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 18:01
 * Version: 1.0
 * Description:
 */
abstract class BaseApplication : Application() {
    companion object {
        @JvmStatic
        var INSTANCE: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}