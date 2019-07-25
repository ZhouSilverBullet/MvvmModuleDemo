package com.zhousaito.mvvmmoduledemo.ui

import androidx.fragment.app.FragmentPagerAdapter
import com.zhousaito.base.BaseActivity
import com.zhousaito.mvvmmoduledemo.R
import com.zhousaito.mvvmmoduledemo.databinding.ActivityViewPagerBinding
import com.zhousaito.mvvmmoduledemo.ui.adapter.VPAdapter

class ViewPagerActivity : BaseActivity<ActivityViewPagerBinding, VPViewModel>() {

    val arrayList = ArrayList<String>()

    override fun layoutId() = R.layout.activity_view_pager

    override fun vmClazz() = VPViewModel::class.java

    override fun initView() {
        arrayList.add("新闻1")
        arrayList.add("新闻2")
        arrayList.add("新闻3")
        arrayList.add("新闻4")


        mBinding.vpView.adapter = VPAdapter(arrayList, supportFragmentManager,
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        mBinding.vpView.offscreenPageLimit = 4
        mBinding.tlTab.setupWithViewPager(mBinding.vpView)
    }

    override fun initObserve() {
    }

    override fun initData() {
    }


}
