package com.zhousaito.mvvmmoduledemo.ui

import androidx.lifecycle.MutableLiveData
import com.zhousaito.base.BaseViewModel
import com.zhousaito.mvvmmoduledemo.model.api.RetrofitClient.apiService
import com.zhousaito.mvvmmoduledemo.model.data.ChapterData

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 16:07
 * Version: 1.0
 * Description:
 */
class VPViewModel : BaseViewModel() {
    var chapterList = MutableLiveData<List<ChapterData>>()

    fun loadData() {
        loadOnUI({
            val baseResponse = apiService.chapter()
            chapterList.value = baseResponse.data
        }, { t ->
            mThrowable.value = t
        })
    }
}