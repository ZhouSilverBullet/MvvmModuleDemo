package com.zhousaito.base

import androidx.lifecycle.ViewModel

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 22:25
 * Version: 1.0
 * Description:
 */
interface IVMView<VM : ViewModel> : IView {
    /**
     * vm 的className
     *
     */
    fun vmClazz(): Class<VM>
}