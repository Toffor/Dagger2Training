package com.coskun.dagger2training.data

import com.coskun.dagger2training.di.Remote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Coskun Yalcinkaya.
 */

@Singleton
class CityRepository @Inject constructor(@Remote private val cityRemoteDataSource: CityDataSource) : CityDataSource{

    override fun getCities(callback: (List<String>) -> Unit) {
        cityRemoteDataSource.getCities(callback)
    }
}