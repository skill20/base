package com.small.login

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.small.login_service.LOGIN_SERVICE
import com.small.login_service.LoginService

/**
 * Create by wangqingqing
 * On 2019/8/29 13:33
 * Copyright(c) 2018 极光
 * Description
 */
@Route(path = LOGIN_SERVICE)
class LoginServiceImp : LoginService {
    override fun init(context: Context?) {
    }

    override fun isLogin() = false
}