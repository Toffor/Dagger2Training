package com.coskun.dagger2training.ui.main


import android.os.Bundle
import android.view.View
import com.coskun.dagger2training.R
import com.coskun.dagger2training.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_child1.*
import javax.inject.Inject


/**
 * Created by Coskun Yalcinkaya.
 */
class Child1Fragment() : BaseFragment() {

    @Inject lateinit var navigator: Navigator

    companion object {
        fun newInstance() = Child1Fragment()
    }

    override fun getLayoutId() = R.layout.fragment_child1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next_fragment.setOnClickListener { navigator.navigateToChild2Fragment(parentFragment as ParentFragment) }
    }

}
