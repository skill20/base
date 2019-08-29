package com.small.login_service

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Create by wangqingqing
 * On 2019/8/29 13:29
 * Copyright(c) 2018 极光
 * Description
 */
interface LoginService : IProvider {

    fun isLogin(): Boolean
}