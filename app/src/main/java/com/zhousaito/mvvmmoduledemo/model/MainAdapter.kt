package com.zhousaito.mvvmmoduledemo.model

import android.util.Log
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhousaito.mvvmmoduledemo.R
import com.zhousaito.mvvmmoduledemo.model.data.ChapterData

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-07-24 17:42
 * Version: 1.0
 * Description:
 */

class MainAdapter(layoutResId: Int = R.layout.recycler_view_item) : BaseQuickAdapter<ChapterData, BaseViewHolder>(layoutResId) {
    val TAG = "MainAdapter"
    override fun convert(helper: BaseViewHolder?, item: ChapterData?) {
        helper?.getView<TextView>(R.id.textView)?.text = item?.name
//        Log.i(TAG, "-------------------> ")
//        Log.i(TAG, item?.toString())
    }

}