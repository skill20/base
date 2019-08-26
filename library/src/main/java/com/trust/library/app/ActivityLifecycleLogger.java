package com.trust.library.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

/**
 * Create by wangqingqing
 * On 2019/4/15 14:56
 * Copyright(c) 2018 极光
 * Description
 */
public class ActivityLifecycleLogger implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ActivityStackHelper.push(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Logger.v(activity.getClass().getSimpleName(), "onStarted");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Logger.v(activity.getClass().getSimpleName(), "onResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Logger.v(activity.getClass().getSimpleName(), "onPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Logger.v(activity.getClass().getSimpleName(), "onStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Logger.v(activity.getClass().getSimpleName(), "onSaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Logger.v(activity.getClass().getSimpleName(), "onDestroyed");
        ActivityStackHelper.remove(activity);
    }


}