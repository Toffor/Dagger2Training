package com.coskun.dagger2training.ui.main


import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.coskun.dagger2training.R
import com.coskun.dagger2training.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_child1.*
import javax.inject.Inject


/**
 * Created by Coskun Yalcinkaya.
 */
class Child1Fragment() : BaseFragment(), ParentFragmentView{

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var presenter: ParentFragmentPresenter

    companion object {
        fun newInstance() = Child1Fragment()
    }

    override fun getLayoutId() = R.layout.fragment_child1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next_fragment.setOnClickListener { navigator.navigateToChild2Fragment(parentFragment as ParentFragment) }
        presenter.view = this
        presenter.getCities()
    }

    override fun showLoading() {
        Toast.makeText(context, "showLoading", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(context, "hideLoading", Toast.LENGTH_SHORT).show()
    }

    override fun renderCities(cityList: List<String>) {
        Toast.makeText(context, cityList.toString(), Toast.LENGTH_SHORT).show()
    }

}
