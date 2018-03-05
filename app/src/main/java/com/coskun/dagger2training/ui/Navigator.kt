package com.coskun.dagger2training.ui
import com.coskun.dagger2training.di.PerActivity
import com.coskun.dagger2training.extension.logDebug
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */

@PerActivity
class Navigator @Inject constructor(mainActivity: MainActivity) {

    private val fragmentManager = mainActivity.supportFragmentManager


    fun logBackStackEntryCount(){
        logDebug(fragmentManager.backStackEntryCount)
    }
}