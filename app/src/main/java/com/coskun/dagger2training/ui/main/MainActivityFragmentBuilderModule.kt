package com.coskun.dagger2training.ui.main

import com.coskun.dagger2training.di.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Coskun Yalcinkaya.
 */

@Module
abstract class MainActivityFragmentBuilderModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeParentFragment() : ParentFragment
}