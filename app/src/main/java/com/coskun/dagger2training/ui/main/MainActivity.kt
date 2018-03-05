package com.coskun.dagger2training.ui.main

import android.os.Bundle
import com.coskun.dagger2training.R
import com.coskun.dagger2training.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.init(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
