package com.small.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.jeremyliao.liveeventbus.LiveEventBus
import com.orhanobut.logger.Logger
import com.trust.library.arouter.RouterPath
import com.trust.library.fragment.BaseTitleFragment

/**
 * Create by wangqingqing
 * On 2019/8/23 17:42
 * Copyright(c) 2018 极光
 * Description
 */
@Route(path = RouterPath.FRAGMENT_FEATURE_2)
class Demo1Fragment : BaseTitleFragment() {

    override fun getContentLayout() = R.layout.fragment_demo1

    override fun supportNetLayout() = true

    private lateinit var featureViewModel: FeatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.i("Demo1Fragment ${hashCode()} onCreate")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getBaseRootDelegate().titleLayout.visibility = View.GONE
        getBaseRootDelegate().netStateManager.showLoadingLayout()

        featureViewModel = activity.let {
            ViewModelProvider(it!!).get(FeatureViewModel::class.java)
        }


        featureViewModel.value.observe(this, Observer {
            Logger.i("Demo1Fragment $it ")
        })

        LiveEventBus.get().with("post_value", String::class.java).observe(this, Observer {
            Logger.i("Demo1Fragment from post $it ")
        })
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

    override fun onStop() {
        super.onStop()
        Logger.i("Demo1Fragment ${hashCode()} onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i("Demo1Fragment ${hashCode()} onDestroy")
    }
}