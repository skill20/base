package com.small.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.orhanobut.logger.Logger

/**
 * Create by wangqingqing
 * On 2019/8/23 17:42
 * Copyright(c) 2018 极光
 * Description
 */
class Demo2Fragment : Fragment() {

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

    override fun onStart() {
        super.onStart()
        Logger.i("Demo2Fragment  ${hashCode()} onStart")
    }

    override fun onResume() {
        super.onResume()

        Logger.i("Demo2Fragment  ${hashCode()} onResume ${lifecycle.currentState}")


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