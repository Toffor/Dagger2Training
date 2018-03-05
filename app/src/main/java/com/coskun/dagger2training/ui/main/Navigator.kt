package com.coskun.dagger2training.ui.main
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.coskun.dagger2training.R
import com.coskun.dagger2training.di.PerActivity
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

    fun initChildFragment(fragment: ParentFragment){
        replaceFragment(Child1Fragment.newInstance(), fragment.childFragmentManager, R.id.parent_fragment_container)
    }

    private fun replaceFragment(fragment: Fragment, fm: FragmentManager = fragmentManager, containerId: Int = R.id.main_fragment_container){
        fm
                .beginTransaction()
                .replace(containerId, fragment, fragment::class.java.canonicalName)
                .addToBackStack(null)
                .commit()
    }
}