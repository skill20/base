package com.trust.library.fragment

import android.os.Bundle
import android.view.ViewGroup
import com.trust.library.state.StatusLayoutManager

/**
 * Create by wangqingqing
 * On 2019/9/2 14:06
 * Copyright(c) 2018 极光
 * Description
 */
abstract class BaseTitleActivity : BaseActivity(), BaseRootInterface {

    private lateinit var delegate: BaseRootDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentParent = findViewById<ViewGroup>(android.R.id.content)
        delegate = BaseRootDelegate(this, this)
        delegate.onCreate(contentParent)
        setContentView(delegate.rootView)
    }

    fun getBaseRootDelegate() = delegate

    override fun setNetStateBuilder(builder: StatusLayoutManager.Builder?) {

    }
}