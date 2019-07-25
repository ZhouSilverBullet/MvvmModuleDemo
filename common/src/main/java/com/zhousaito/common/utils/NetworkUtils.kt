package com.zhousaito.common.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 14:41
 * Version: 1.0
 * Description:
 */

object NetworkUtils {
    fun isNetworkAvailable(context: Context): Boolean {
        var systemService = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo = systemService.activeNetworkInfo
        return activeNetworkInfo?.isAvailable ?: false
    }
}