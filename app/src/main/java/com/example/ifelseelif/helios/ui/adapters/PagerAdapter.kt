package com.example.ifelseelif.helios.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.ifelseelif.helios.ui.fragments.ChatFragment
import com.example.ifelseelif.helios.ui.fragments.ProfileFragment
import com.example.ifelseelif.helios.ui.fragments.QueueFragment

class PagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    val listFragments = ArrayList<Fragment>()
    val listTitles = ArrayList<String>()

    override fun getCount(): Int {
        return listFragments.size
    }

    override fun getItem(p0: Int): Fragment {
        return listFragments[p0]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitles[position]
    }

    fun addFragment(fragment : Fragment, title : String) {
        listFragments.add(fragment)
        listTitles.add(title)
    }


}