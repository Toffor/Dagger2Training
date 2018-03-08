package com.coskun.dagger2training.ui.main

/**
 * Created by Coskun Yalcinkaya.
 */
interface ParentFragmentView {

    fun showLoading()

    fun hideLoading()

    fun renderCities(cityList: List<String>)
}