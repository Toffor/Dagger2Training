package com.coskun.dagger2training.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.coskun.dagger2training.di.FragmentAndroidInjector
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector{

    @Inject lateinit var fragmentAndroidInjector: FragmentAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun supportFragmentInjector() = fragmentAndroidInjector
}