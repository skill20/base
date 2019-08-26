package com.small.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.orhanobut.logger.Logger
import com.trust.library.arouter.RouterPath

/**
 * Create by wangqingqing
 * On 2019/8/23 17:42
 * Copyright(c) 2018 极光
 * Description
 */
@Route(path = RouterPath.FRAGMENT_FEATURE_2)
class Demo1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo1, null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.i("Demo1Fragment ${hashCode()} onCreate")
    }

    override fun onStart() {
        super.onStart()
        Logger.i("Demo1Fragment ${hashCode()} onStart")
    }

    override fun onResume() {
        super.onResume()
        Logger.i("Demo1Fragment ${hashCode()} onResume ${lifecycle.currentState}")
        if (lifecycle.currentState == Lifecycle.State.STARTED) {

        }
    }

    override fun onPause() {
        super.onPause()
        Logger.i("Demo1Fragment ${hashCode()} onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i("Demo1Fragment ${hashCode()} onDestroy")
    }
}