package com.example.ifelseelif.helios.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.ifelseelif.helios.R
import com.example.ifelseelif.helios.mvp.presentors.fragmentsPresentors.ProfilePresenter
import com.example.ifelseelif.helios.mvp.views.fragments.ProfileFragmentView

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : MvpAppCompatFragment(), SwipeRefreshLayout.OnRefreshListener,
    ProfileFragmentView {

    override fun onRefresh() {
        presenter.onRefresh()
    }

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.onRefresh()
    }


}
