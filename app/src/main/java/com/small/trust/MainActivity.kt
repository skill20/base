package com.small.trust

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.trust.library.arouter.RouterPath

@Route(path = RouterPath.ACTIVITY_MAIN)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment =
            ARouter.getInstance().build(RouterPath.FRAGMENT_FEATURE).navigation() as Fragment
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .setMaxLifecycle(
                fragment,
                Lifecycle.State.RESUMED
            ).commitNow()
    }
}
