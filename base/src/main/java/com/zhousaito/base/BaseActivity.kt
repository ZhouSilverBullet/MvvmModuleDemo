package com.zhousaito.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 15:19
 * Version: 1.0
 * Description:
 */
abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity(), IVMView<VM> {
    companion object {
        const val TAG = "BaseActivity"
    }

    val mBinding: DB by lazy {
        setContentView<DB>(this, layoutId())
    }

    val mViewModel: VM by lazy {
        ViewModelProviders.of(this@BaseActivity)[vmClazz()]

//        下面这种方式是反射获取的，有时候会比较影响性能
//        ViewModelProviders.of(this@BaseActivity)[getVmClass()]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()

        initView()
        initObserve()
        initData()
    }


//    inline fun <reified vm : ViewModel> bindViewModel(): vm {
//        return ViewModelProviders.of(this@BaseActivity)[vm::class.java]
//    }

    //反射获取到baseActivity上面的泛型
//    fun getVmClass(): Class<VM> {
//        return (this@BaseActivity::javaClass.get().genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VM>
//    }

}