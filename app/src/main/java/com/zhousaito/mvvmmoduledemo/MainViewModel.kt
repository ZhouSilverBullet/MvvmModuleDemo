package com.zhousaito.mvvmmoduledemo

import androidx.lifecycle.MutableLiveData
import com.zhousaito.base.BaseViewModel
import com.zhousaito.mvvmmoduledemo.model.api.RetrofitClient
import com.zhousaito.mvvmmoduledemo.model.data.BannerData
import com.zhousaito.mvvmmoduledemo.model.data.ChapterData

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 17:07
 * Version: 1.0
 * Description:
 */
class MainViewModel : BaseViewModel() {
    val baidu = MutableLiveData<List<BannerData>>()
    val chapter = MutableLiveData<List<ChapterData>>()


    fun load() {
        loadOnUI({
            val chapterValue = RetrofitClient.apiService.chapter()
            this@MainViewModel.chapter.value = chapterValue.data
        }, finallyBack = {

        })
    }
}