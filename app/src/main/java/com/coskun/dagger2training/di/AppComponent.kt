package com.coskun.dagger2training.di

import android.app.Application
import com.coskun.dagger2training.App
import com.coskun.dagger2training.data.CityRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Coskun Yalcinkaya.
 */

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    CityRepositoryModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: App)
}