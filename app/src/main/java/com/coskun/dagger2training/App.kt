package com.coskun.dagger2training

import android.app.Application
import com.coskun.dagger2training.di.ActivityAndroidInjector
import com.coskun.dagger2training.di.DaggerAppComponent
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */
class App : Application(), HasActivityInjector {

    @Inject lateinit var activityAndroidInjector: ActivityAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector() = activityAndroidInjector

}