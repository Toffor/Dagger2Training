package com.coskun.dagger2training.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coskun.dagger2training.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.logBackStackEntryCount()
    }
}
