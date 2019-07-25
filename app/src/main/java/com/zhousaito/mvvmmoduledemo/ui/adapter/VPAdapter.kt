package com.zhousaito.mvvmmoduledemo.ui.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.zhousaito.mvvmmoduledemo.ui.fragment.NewsFragment

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-25 16:21
 * Version: 1.0
 * Description:
 */
class VPAdapter(val titleList: ArrayList<String>, fragmentManager: FragmentManager, behavior: Int)
    : FragmentPagerAdapter(fragmentManager, behavior) {

    override fun getItem(position: Int): Fragment {
        return NewsFragment.newInstance("<--${position}-->")
    }

    override fun getCount(): Int {
        return titleList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}