package com.trust.library.app

import android.app.Application
import android.os.Build
import com.alibaba.android.arouter.launcher.ARouter
import com.hjq.toast.ToastUtils
import com.liulishuo.filedownloader.FileDownloader
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.tencent.mmkv.MMKV
import com.trust.library.BuildConfig


/**
 * Create by wangqingqing
 * On 2019/4/15 14:57
 * Copyright(c) 2018 极光
 * Description
 */
object AppConfig {

    lateinit var application: Application

    fun init(application: Application) {
        this.application = application

        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application)

        //初始化本地的统计
//        AnalyticsMgr.init(application, LibraryConfig.ACTIVE_REPORT_URL)
        //初始化统计分析
//        JAnalyticsInterface.setDebugMode(BuildConfig.DEBUG)
//        JAnalyticsInterface.init(application)

        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

        //轻量key-value存储
        MMKV.initialize(application)
        //添加全局activity监听
        application.registerActivityLifecycleCallbacks(ActivityLifecycleLogger())

        ToastUtils.init(application)


        //文件下载器初始化
        FileDownloader.setupOnApplicationOnCreate(application)

        //Android P 后谷歌限制了开发者调用非官方公开API 方法或接口，也就是说，你用反射直接调用源码就会有这样的提示弹窗出现，
        // 非 SDK 接口指的是 Android 系统内部使用、并未提供在 SDK 中的接口，开发者可能通过 Java 反射、JNI 等技术来调用这些接口。
        // 此方法可以关闭android P的提示警告弹窗
        closeAndroidPDialog()
    }

    private fun closeAndroidPDialog() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.P) {
            try {
                val aClass = Class.forName("android.content.pm.PackageParser\$Package")
                val declaredConstructor = aClass.getDeclaredConstructor(String::class.java)
                declaredConstructor.isAccessible = true
                val cls = Class.forName("android.app.ActivityThread")
                val declaredMethod = cls.getDeclaredMethod("currentActivityThread")
                declaredMethod.isAccessible = true
                val activityThread = declaredMethod.invoke(null)
                val mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown")
                mHiddenApiWarningShown.isAccessible = true
                mHiddenApiWarningShown.setBoolean(activityThread, true)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}