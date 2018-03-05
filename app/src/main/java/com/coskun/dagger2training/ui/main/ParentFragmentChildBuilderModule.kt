package com.coskun.dagger2training.ui.main

import com.coskun.dagger2training.di.PerChildFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Coskun Yalcinkaya.
 */

@Module
abstract class ParentFragmentChildBuilderModule {

    @PerChildFragment
    @ContributesAndroidInjector
    abstract fun contributeChild1Fragment() : Child1Fragment
}