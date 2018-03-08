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
class Navigator @Inject constructor() {

    private var fragmentManger : FragmentManager? = null

    fun init(mainActivity: MainActivity){
        fragmentManger = mainActivity.supportFragmentManager
        if (fragmentManger!!.backStackEntryCount == 0)
            replaceFragment(ParentFragment.newInstance())
    }

    fun initChild1Fragment(fragment: ParentFragment){
        val childFragmentManager = fragment.childFragmentManager
        if (childFragmentManager.backStackEntryCount == 0)
        replaceFragment(Child1Fragment.newInstance(), childFragmentManager, R.id.parent_fragment_container)
    }

    fun navigateToChild2Fragment(fragment: ParentFragment){
        replaceFragment(Child2Fragment.newInstance(), fragment.childFragmentManager, R.id.parent_fragment_container)
    }

    private fun replaceFragment(fragment: Fragment, fm: FragmentManager? = fragmentManger, containerId: Int = R.id.main_fragment_container){
        fm
                ?.beginTransaction()
                ?.replace(containerId, fragment, fragment::class.java.canonicalName)
                ?.addToBackStack(null)
                ?.commitAllowingStateLoss()
    }
}