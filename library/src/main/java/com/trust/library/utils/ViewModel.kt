package com.trust.library.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Create by wangqingqing
 * On 2019/8/26 15:29
 * Copyright(c) 2018 极光
 * Description
 */
fun ViewModel.launch(
    block: suspend CoroutineScope.() -> Unit,
    error: suspend (Exception) -> Unit
) {
    viewModelScope.launch {
        try {
            block()
        } catch (e: Exception) {
            error(e)
        }
    }
}