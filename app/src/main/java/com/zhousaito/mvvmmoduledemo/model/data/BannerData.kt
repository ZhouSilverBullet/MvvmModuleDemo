package com.zhousaito.mvvmmoduledemo.model.data

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 17:14
 * Version: 1.0
 * Description:
 */
data class BaseResponse<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)

data class BannerData(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)