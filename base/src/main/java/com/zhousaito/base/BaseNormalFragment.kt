package com.zhousaito.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 18:29
 * Version: 1.0
 * Description:
 */
abstract class BaseNormalFragment<DB : ViewDataBinding> : Fragment(), IView {
    companion object {
        const val TAG = "BaseFragment"
    }

    lateinit var mBinding: DB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate<DB>(inflater, layoutId(), container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

}