package com.trust.library.fragment;

/**
 * Create by wangqingqing
 * On 2019/3/7 11:30
 * Copyright(c) 2018 极光
 * Description
 */
public interface NetworkState {
    void showLoading();
    void showEmpty();
    void showError();
    void showContent();
}
