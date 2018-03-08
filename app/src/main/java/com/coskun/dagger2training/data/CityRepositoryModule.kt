package com.coskun.dagger2training.data

import com.coskun.dagger2training.di.Remote
import dagger.Binds
import dagger.Module

/**
 * Created by Coskun Yalcinkaya.
 */

@Module
abstract class CityRepositoryModule {

    @Binds
    @Remote
    abstract fun bindRemoteDataSource(cityRemoteDataSource: CityRemoteDataSource) : CityDataSource

}