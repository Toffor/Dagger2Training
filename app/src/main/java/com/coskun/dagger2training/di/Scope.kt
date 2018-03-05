package com.coskun.dagger2training.di

import javax.inject.Scope

/**
 * Created by Coskun Yalcinkaya.
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerChildFragment