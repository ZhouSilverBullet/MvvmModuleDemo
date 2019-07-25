package com.zhousaito.base

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 22:24
 * Version: 1.0
 * Description:
 */

interface IView {
    /**
     * activity的布局
     */
    fun layoutId(): Int


    /**
     * 初始化界面的一些操作
     */
    fun initView()

    /**
     * 初始化 vm的Observe
     * 用于需要处理后的数据进行界面交互的
     *
     */
    fun initObserve()

    /**
     * 初始化数据，或者获取数据
     */
    fun initData()
}