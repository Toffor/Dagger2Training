package com.coskun.dagger2training.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.coskun.dagger2training.App
import com.coskun.dagger2training.di.FragmentAndroidInjector
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector
import java.util.*
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector{

    companion object {
        const val INSTANCE_ID = "instance_id"
    }

    @Inject lateinit var fragmentAndroidInjector: FragmentAndroidInjector

    lateinit var instanceId: String private set

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = savedInstanceState?.getString(INSTANCE_ID) ?: UUID.randomUUID().toString()
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID, instanceId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isFinishing) (application as App).activityAndroidInjector.clearCache(this)
    }

    override fun supportFragmentInjector() = fragmentAndroidInjector

    @LayoutRes
    abstract fun getLayoutId(): Int
}