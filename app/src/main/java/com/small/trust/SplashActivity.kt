package com.small.trust

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

/**
 * Create by wangqingqing
 * On 2019/4/17 14:18
 * Copyright(c) 2018 极光
 * Description
 */
class SplashActivity : AppCompatActivity() {

    private val handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        handler.postDelayed(
            {
                startActivity(Intent(baseContext, MainActivity::class.java))
                finish()
            },
            2000
        )

    }

    override fun onBackPressed() {

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}