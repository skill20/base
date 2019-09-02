package com.trust.library.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trust.library.R
import com.trust.library.state.StatusLayoutManager

/**
 * Create by wangqingqing
 * On 2019/8/26 16:05
 * Copyright(c) 2018 极光
 * Description
 */
abstract class BaseTitleFragment : BaseFragment(), BaseRootInterface {

    private lateinit var delegate: BaseRootDelegate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        delegate = BaseRootDelegate(activity, this)
        delegate.onCreate(container)
        return delegate.rootView
    }

    fun getBaseRootDelegate() = delegate

    override fun setNetStateBuilder(builder: StatusLayoutManager.Builder?) {
        builder?.apply {
            setLoadingLayout(R.layout.layout_loading)
        }
    }

}