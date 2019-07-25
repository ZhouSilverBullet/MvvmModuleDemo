package com.zhousaito.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhousaito.common.utils.NetworkUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 20:01
 * Version: 1.0
 * Description:
 */
abstract class BaseViewModel : ViewModel() {
    val mThrowable = MutableLiveData<Throwable>()

    fun loadOnUI(block: suspend CoroutineScope.() -> Unit,
                 catchBack: suspend CoroutineScope.(t: Throwable) -> Unit = {},
                 finallyBack: suspend CoroutineScope.() -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                if (NetworkUtils.isNetworkAvailable(BaseApplication.INSTANCE)) {
                    block()
                } else {
                    catchBack(UnknownHostException())
                }
            } catch (e: Exception) {
                catchBack(e)
            } finally {
                finallyBack()
            }
        }
    }

}