package com.trust.library.arouter

import android.app.Activity
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback

/**
 * Create by wangqingqing
 * On 2019/4/15 14:22
 * Copyright(c) 2018 极光
 * Description
 */
object RouterPath {

    const val ACTIVITY_MAIN = "/app/activity"
    const val FRAGMENT_FEATURE = "/feature/fragment"
    const val FRAGMENT_FEATURE_2 = "/feature/fragment2"

    const val FRAGMENT_LOGIN = "/login/fragment"
    const val ACTIVITY_LOGIN = "/login/activity"


    /*******************  需要登录的界面 start *************************/

    const val NEED_LOGIN = 99

    const val ACTIVITY_LOGIN_SUC = "/suc/activity"


    /*******************  需要登录的界面 end *************************/


    /*******************  module提供的服务 start *************************/

    const val SERVICE_LOGIN = "/service/login"

    /*******************  module提供的服务 end *************************/


    fun startNewActivityAndFinishSelf(activity: Activity): NavigationCallback {
        return object : NavigationCallback {
            override fun onLost(postcard: Postcard?) {
            }

            override fun onFound(postcard: Postcard?) {
            }

            override fun onInterrupt(postcard: Postcard?) {
            }

            override fun onArrival(postcard: Postcard?) {
                activity.finish()
            }

        }
    }
}