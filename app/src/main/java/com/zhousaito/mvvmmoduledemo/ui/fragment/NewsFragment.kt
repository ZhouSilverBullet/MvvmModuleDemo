package com.zhousaito.mvvmmoduledemo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.zhousaito.mvvmmoduledemo.R
import com.zhousaito.mvvmmoduledemo.model.MainAdapter
import com.zhousaito.mvvmmoduledemo.ui.VPViewModel
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * A simple [Fragment] subclass.
 *
 */
class NewsFragment : Fragment() {


    companion object {
        const val TAG = "NewsFragment"
        fun newInstance(title: String): NewsFragment {
            var bundle = Bundle()
            bundle.putString("title", title)
            val newsFragment = NewsFragment()
            newsFragment.arguments = bundle
            return newsFragment
        }
    }

    val string by lazy {
        arguments?.getString("title")
    }

    val viewModel = VPViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i(TAG, "onCreateView : $string")

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated : $string")

//        tv_frag.text = tv_frag.text.toString() + string

        rv.layoutManager = LinearLayoutManager(context)
        val mainAdapter = MainAdapter()
        rv.adapter = mainAdapter
        viewModel.chapterList.observe(this, Observer {
            mainAdapter.addData(it)

            srl_layout.finishRefresh(200)
            srl_layout.finishLoadMore(200)

        })

        viewModel.mThrowable.observe(this, Observer {
            srl_layout.finishRefresh(200, false, mainAdapter.data.isEmpty())
        })

        srl_layout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                viewModel.loadData()
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                viewModel.loadData()
            }

        })
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.i(TAG, "setUserVisibleHint : $string")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.i(TAG, "onCreate : $string")

    }

    var isLoad =false;
    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume : $string --- isLoad : $isLoad")
        if (!isLoad) {
            isLoad = true
            srl_layout.autoRefresh()
        }


    }

//    override fun onPause() {
//        super.onPause()
//        Log.i(TAG, "onPause : $string")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.i(TAG, "onDetach : $string")
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.i(TAG, "onDestroyView : $string")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i(TAG, "onDestroy : $string")
//    }
}
