package com.zhousaito.mvvmmoduledemo.model.data

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 18:18
 * Version: 1.0
 * Description:
 */
data class ChapterData(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)