package com.coskun.dagger2training.data

/**
 * Created by Coskun Yalcinkaya.
 */

interface CityDataSource {

    fun getCities(callback: (List<String>) -> Unit)
}