//package com.zhousaito.mvvmmoduledemo
//
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil.setContentView
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.zhousaito.mvvmmoduledemo.databinding.ActivityMainBinding
//import com.zhousaito.mvvmmoduledemo.model.MainAdapter
//import kotlinx.coroutines.MainScope
//
//class MainActivity2 : AppCompatActivity() {
//    val TAG = "MainActivity"
//
//    val mainScope = MainScope()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val binding = setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        val mainAdapter = MainAdapter()
//        binding.rv.layoutManager = LinearLayoutManager(this)
//        binding.rv.adapter = mainAdapter;
//
//        val mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
//        mainViewModel.chapter.observe(this, Observer {
//            Log.i(TAG, "it ---> $it")
//            mainAdapter.addData(it)
//
//        })
//
//        mainViewModel.load()
//
//
////        reqBaidu.setOnClickListener {
////            mainScope.launch {
////                try {
////
////                    tvText.setText(baidu.toString())
////                } catch (e: Exception) {
////                    tvText.setText("e=$e")
////                }
////
////            }
////
////        }
//
//
//    }
//}
