package com.coskun.dagger2training.ui.main

import android.os.Bundle
import android.view.View
import com.coskun.dagger2training.R
import com.coskun.dagger2training.ui.base.BaseFragment
import javax.inject.Inject


/**
 * Created by Coskun Yalcinkaya.
 */

class ParentFragment() : BaseFragment() {

    companion object {
        fun newInstance() = ParentFragment()
    }

    @Inject lateinit var navigator: Navigator

    override fun getLayoutId() = R.layout.fragment_parent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigator.initChild1Fragment(this)
    }

}
