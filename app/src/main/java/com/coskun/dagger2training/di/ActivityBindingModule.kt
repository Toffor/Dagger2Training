package com.coskun.dagger2training.di

import com.coskun.dagger2training.ui.main.MainActivity
import com.coskun.dagger2training.ui.main.MainActivityFragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Coskun Yalcinkaya.
 */

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilderModule::class])
    abstract fun contributeMainActivity() : MainActivity

}