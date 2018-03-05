package com.coskun.dagger2training.ui.main
import android.support.v4.app.Fragment
import com.coskun.dagger2training.R
import com.coskun.dagger2training.di.PerActivity
import com.coskun.dagger2training.extension.logDebug
import javax.inject.Inject

/**
 * Created by Coskun Yalcinkaya.
 */

@PerActivity
class Navigator @Inject constructor(mainActivity: MainActivity) {

    private val fragmentManager = mainActivity.supportFragmentManager

    fun init(){
        if(fragmentManager.backStackEntryCount == 0)
            replaceFragment(ParentFragment.newInstance())
    }

    fun logBackStackEntryCount(){

        logDebug(fragmentManager.backStackEntryCount)
    }


    private fun replaceFragment(fragment: Fragment, containerId: Int = R.id.main_fragment_container){
        fragmentManager
                .beginTransaction()
                .replace(containerId, fragment, fragment::class.java.canonicalName)
                .addToBackStack(null)
                .commit()
    }
}