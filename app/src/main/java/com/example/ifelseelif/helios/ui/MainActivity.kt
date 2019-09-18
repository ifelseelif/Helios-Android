package com.example.ifelseelif.helios.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.ifelseelif.helios.R
import com.example.ifelseelif.helios.mvp.presentors.MainPresenter
import com.example.ifelseelif.helios.mvp.views.MainView
import com.example.ifelseelif.helios.ui.fragments.ChatFragment
import com.example.ifelseelif.helios.ui.fragments.ProfileFragment
import com.example.ifelseelif.helios.ui.fragments.QueueFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    val TAG = "ROOT_TAG"

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigationMenu()

    }

    private fun initBottomNavigationMenu() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            presenter.selectItem(it.itemId)
            when (it.itemId) {
                R.id.queue -> {
                    val fragment = QueueFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .addToBackStack(TAG).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.chat -> {
                    val fragment = ChatFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .addToBackStack(TAG).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    val fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                        .addToBackStack(TAG).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        bottom_navigation.selectedItemId = R.id.queue
    }

    override fun closeApp() {
        finishAffinity()
    }

    override fun selectOnBNM(id: Int) {
        bottom_navigation.selectedItemId = id
    }


    override fun onBackPressed() {
        supportFragmentManager.popBackStackImmediate()
        presenter.changeBNM()
    }
}
