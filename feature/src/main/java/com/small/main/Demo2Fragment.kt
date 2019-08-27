package com.small.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hjq.toast.ToastUtils
import com.jeremyliao.liveeventbus.LiveEventBus
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_demo2.*

/**
 * Create by wangqingqing
 * On 2019/8/23 17:42
 * Copyright(c) 2018 极光
 * Description
 */
class Demo2Fragment : Fragment() {


    private lateinit var featureViewModel: FeatureViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo2, null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.i("Demo2Fragment ${hashCode()} onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        featureViewModel = activity.let {
            ViewModelProvider(it!!).get(FeatureViewModel::class.java)
        }

        featureViewModel.value.observe(this, Observer {
           Logger.i("Demo2Fragment $it ")
        })

        post.setOnClickListener {
            val v = "哈哈"
            featureViewModel.value.postValue(v)
//            LiveEventBus.get().with("post_value").post(v)
        }
    }

    override fun onStart() {
        super.onStart()
        Logger.i("Demo2Fragment  ${hashCode()} onStart")
    }

    override fun onResume() {
        super.onResume()

        Logger.i("Demo2Fragment  ${hashCode()} onResume ${lifecycle.currentState}")


    }
    override fun onStop() {
        super.onStop()
        Logger.i("Demo2Fragment ${hashCode()} onStop")
    }
    override fun onPause() {
        super.onPause()
        Logger.i("Demo2Fragment  ${hashCode()} onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i("Demo2Fragment  ${hashCode()} onDestroy")
    }
}