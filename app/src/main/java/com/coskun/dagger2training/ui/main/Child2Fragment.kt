package com.coskun.dagger2training.ui.main


import com.coskun.dagger2training.R
import com.coskun.dagger2training.ui.base.BaseFragment
import javax.inject.Inject


/**
 * Created by Coskun Yalcinkaya.
 */
class Child2Fragment() : BaseFragment() {

    companion object {
        fun newInstance() = Child2Fragment()
    }

    @Inject lateinit var navigator: Navigator

    override fun getLayoutId() = R.layout.fragment_child2


}
