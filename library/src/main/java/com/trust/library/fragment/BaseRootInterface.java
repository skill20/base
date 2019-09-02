package com.trust.library.fragment;

import com.trust.library.state.StatusLayoutManager;


/**
 * Create by wangqingqing
 * On 2019/4/2 15:48
 * Copyright(c) 2018 极光
 * Description
 */
public interface BaseRootInterface {

    /**
     * 最终要显示的布局
     *
     * @return
     */
    int getContentLayout();

    /**
     * 是否需要网络状态的支持
     *
     * @return
     */
    boolean supportNetLayout();

    /**
     * 设置网络状态
     *
     * @param builder
     */
    void setNetStateBuilder(StatusLayoutManager.Builder builder);
}
