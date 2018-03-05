package com.coskun.dagger2training.di

import android.app.Activity
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Coskun Yalcinkaya.
 */
class ActivityAndroidInjector
@Inject constructor(injectorFactories: Map<Class<out Activity>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Activity>>>)
    : CachingAndroidInjector<Activity>(injectorFactories)