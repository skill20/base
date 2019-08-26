package com.trust.library.net

import com.jpush.android.net.RxHttp
import com.trust.library.BuildConfig
import com.trust.library.app.AppConfig
import okhttp3.Interceptor

/**
 * Create by wangqingqing
 * On 2019/8/23 14:44
 * Copyright(c) 2018 极光
 * Description
 */

inline fun <reified T> createApi(baseUrl: String, vararg: Interceptor): T {
    return RxHttp.get().request(baseUrl)
        .setHttpLog(BuildConfig.DEBUG)
        .setInterceptors(arrayOf(vararg))
        .context(AppConfig.application)
        .setRetryOnConnectionFailure(true)
        .createApi<T>(T::class.java)
}