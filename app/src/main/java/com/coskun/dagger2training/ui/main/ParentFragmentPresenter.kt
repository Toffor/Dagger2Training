package com.coskun.dagger2training.ui.main

import com.coskun.dagger2training.data.CityRepository
import com.coskun.dagger2training.di.PerFragment
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */

@PerFragment
class ParentFragmentPresenter @Inject constructor(private val cityRepository: CityRepository) {

    var view : ParentFragmentView? = null

    fun getCities(){

        view?.showLoading()

        cityRepository.getCities {
            view?.hideLoading()
            view?.renderCities(it)
        }
    }
}