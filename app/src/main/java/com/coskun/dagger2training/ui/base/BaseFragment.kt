package com.coskun.dagger2training.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coskun.dagger2training.di.ChildFragmentAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import java.util.*
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */
abstract class BaseFragment : Fragment(), HasSupportFragmentInjector{

    companion object {
        const val INSTANCE_ID = "instance_id"
    }


    @Inject lateinit var childFragmentAndroidInjector: ChildFragmentAndroidInjector


    lateinit var instanceId : String


    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = savedInstanceState?.getString(INSTANCE_ID) ?: UUID.randomUUID().toString()
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    @LayoutRes abstract fun getLayoutId(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(getLayoutId(), container, false)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INSTANCE_ID, instanceId)
    }


    override fun onDestroy() {
        super.onDestroy()
        (parentFragment as? BaseFragment)?.childFragmentAndroidInjector?.clearCache(this)
        (activity as BaseActivity).fragmentAndroidInjector.clearCache(this)
    }

    open fun onBackPressed(){

    }


    override fun supportFragmentInjector() = childFragmentAndroidInjector




}