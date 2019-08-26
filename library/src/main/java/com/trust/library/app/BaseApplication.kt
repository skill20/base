package com.trust.library.app

import android.app.Application
import com.trust.library.imageLoader.ImageLoader

/**
 * Create by wangqingqing
 * On 2019/4/15 14:56
 * Copyright(c) 2018 极光
 * Description
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppConfig.init(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        ImageLoader.trimMemory(this, level)
    }
}