package com.coskun.dagger2training.di

import com.coskun.dagger2training.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Coskun Yalcinkaya.
 */

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

}