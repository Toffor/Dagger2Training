package com.coskun.dagger2training.di

import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Coskun Yalcinkaya.
 */

@PerFragment
class ChildFragmentAndroidInjector
@Inject constructor(injectorFactories: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Fragment>>>)
    : CachingAndroidInjector<Fragment>(injectorFactories)