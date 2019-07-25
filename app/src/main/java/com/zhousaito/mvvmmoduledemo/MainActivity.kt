package com.zhousaito.mvvmmoduledemo

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhousaito.base.BaseActivity
import com.zhousaito.mvvmmoduledemo.databinding.ActivityMainBinding
import com.zhousaito.mvvmmoduledemo.model.MainAdapter
import com.zhousaito.mvvmmoduledemo.ui.ViewPagerActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun layoutId() = R.layout.activity_main

    override fun vmClazz() = MainViewModel::class.java

    val TAG = "MainActivity"

    private val mainAdapter by lazy { MainAdapter() }

    override fun initData() {
        mViewModel.load()
    }

    override fun initView() {
        mBinding.rv.layoutManager = LinearLayoutManager(this)
        mBinding.rv.adapter = mainAdapter;

        mBinding.skipVp.setOnClickListener {
            startActivity(Intent(this@MainActivity, ViewPagerActivity::class.java))
        }
    }

    override fun initObserve() {
        mViewModel.chapter.observe(this, Observer {
            Log.i(TAG, "it ---> $it")
            mainAdapter.addData(it)

        })
    }
}
