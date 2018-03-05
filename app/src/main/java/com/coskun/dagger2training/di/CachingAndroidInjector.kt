package com.coskun.dagger2training.di

import dagger.android.AndroidInjector
import javax.inject.Provider

/**
 * Custom implementation of [AndroidInjector]
 * Created by Coskun Yalcinkaya.
 */

@Suppress("UNCHECKED_CAST")
open class CachingAndroidInjector<T: Any>
constructor(private val injectorFactories: Map<Class<out T>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out T>>>) : AndroidInjector<T> {


    override fun inject(instance: T) {

        val factoryProvider = injectorFactories[instance.javaClass]

        val factory = factoryProvider?.get() as AndroidInjector.Factory<T>

        val injector = factory.create(instance)

        injector.inject(instance)
    }
}