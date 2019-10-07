package com.example.ifelseelif.helios.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.ifelseelif.helios.R
import com.example.ifelseelif.helios.mvp.presentors.MainPresenter
import com.example.ifelseelif.helios.mvp.views.MainView
import com.example.ifelseelif.helios.ui.adapters.PagerAdapter
import com.example.ifelseelif.helios.ui.fragments.ChatFragment
import com.example.ifelseelif.helios.ui.fragments.ProfileFragment
import com.example.ifelseelif.helios.ui.fragments.QueueFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {


    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTabs()
    }

    private fun initTabs() {
        val adapter = PagerAdapter(supportFragmentManager)
        val iconsSelected =
            arrayOf(R.drawable.person_selected, R.drawable.queue_selected, R.drawable.chat_selected)
        val icons = arrayOf(R.drawable.person, R.drawable.queue, R.drawable.chat)
        adapter.addFragment(ProfileFragment(), "")
        adapter.addFragment(QueueFragment(), "")
        adapter.addFragment(ChatFragment(), "")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        for (i in 0..2) {
            tabs.getTabAt(i)!!.setIcon(icons[i])
        }
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                onTabSelected(p0)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    tabs.getTabAt(p0.position)!!.setIcon(icons[p0.position])
                }
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    tabs.getTabAt(p0.position)!!.setIcon(iconsSelected[p0.position])
                    presenter.selectItem(p0.position)
                }
            }
        })
        tabs.getTabAt(1)!!.select()

    }

    override fun closeApp() {
        finishAffinity()
    }

    override fun selectOnBNM(id: Int) {
        tabs.getTabAt(id)!!.select()
    }


    override fun onBackPressed() {
        presenter.changeBNM()
    }
}
