package com.coskun.dagger2training.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coskun.dagger2training.di.ChildFragmentAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */
abstract class BaseFragment : Fragment(), HasSupportFragmentInjector{

    @Inject lateinit var childFragmentAndroidInjector: ChildFragmentAndroidInjector

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(getLayoutId(), container, false)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector() = childFragmentAndroidInjector

    @LayoutRes
    abstract fun getLayoutId(): Int


}