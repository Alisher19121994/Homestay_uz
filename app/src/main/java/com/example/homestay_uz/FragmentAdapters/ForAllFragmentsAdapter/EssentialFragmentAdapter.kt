package com.example.homestay_uz.FragmentAdapters.ForAllFragmentsAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class EssentialFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val listOfFragment = ArrayList<Fragment>()
    private val listOfTitles = ArrayList<String>()

    fun addToViewPager(fragment: Fragment, string: String) {
        listOfFragment.add(fragment)
        listOfTitles.add(string)
    }

    override fun getCount(): Int {
        return listOfFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return listOfFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listOfTitles[position]
    }
}