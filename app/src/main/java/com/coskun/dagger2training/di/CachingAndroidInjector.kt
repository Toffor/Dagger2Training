package com.coskun.dagger2training.di

import com.coskun.dagger2training.ui.base.BaseActivity
import com.coskun.dagger2training.ui.base.BaseFragment
import dagger.android.AndroidInjector
import javax.inject.Provider

/**
 * Custom implementation of [AndroidInjector]
 * Created by Coskun Yalcinkaya.
 */

@Suppress("UNCHECKED_CAST")
open class CachingAndroidInjector<T: Any>
constructor(private val injectorFactories: Map<Class<out T>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out T>>>) : AndroidInjector<T> {

    private val cache = mutableMapOf<String, AndroidInjector<T>>()

    override fun inject(instance: T) {

        val instanceId = when(instance){
            is BaseActivity -> instance.instanceId
            is BaseFragment -> instance.instanceId
            else -> throw IllegalArgumentException("Instance must be one of the base types.")
        }

        if (cache.containsKey(instanceId)){
            cache[instanceId]!!.inject(instance)
            return
        }

        val factoryProvider = injectorFactories[instance.javaClass]

        val factory = factoryProvider?.get() as AndroidInjector.Factory<T>

        val injector = factory.create(instance)

        cache[instanceId] = injector

        injector.inject(instance)
    }

    fun clearCache(instance: T){
        when(instance){
            is BaseActivity -> cache.remove(instance.instanceId)
            is BaseFragment -> cache.remove(instance.instanceId)
        }
    }
}