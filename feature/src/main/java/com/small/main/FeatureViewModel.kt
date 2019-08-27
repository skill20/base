package com.small.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Create by wangqingqing
 * On 2019/8/26 17:16
 * Copyright(c) 2018 极光
 * Description
 */
class FeatureViewModel : ViewModel() {

    val value = MutableLiveData<String>()

}