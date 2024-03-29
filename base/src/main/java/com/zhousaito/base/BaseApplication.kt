package com.zhousaito.base

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.zhousaito.common.receiver.ConnectivityReceiver
import leakcanary.LeakCanary
import leakcanary.LeakSentry
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

        ConnectivityReceiver.register(this)

        LeakSentry.config = LeakSentry.config.copy(watchFragmentViews = false)
    }
}