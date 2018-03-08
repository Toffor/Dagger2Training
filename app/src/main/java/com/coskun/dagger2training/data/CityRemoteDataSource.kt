package com.coskun.dagger2training.data

import android.os.Handler
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Coskun Yalcinkaya.
 */

@Singleton
class CityRemoteDataSource @Inject constructor() : CityDataSource {

    override fun getCities(callback: (List<String>) -> Unit) {
        Handler().postDelayed({
            callback.invoke(cityList)
        }, 500)
    }

    private val cityList = listOf("Istanbul", "Rome", "Paris", "Madrid", "Stockholm", "Tokyo", "Toronto")


}