package com.example.homestay_uz.FragmentAdapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Onboarding(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var listOfFragment = ArrayList<Fragment>()
    private var listOfFragmentStrings = ArrayList<String>()

     fun addFragmentLists(fragment: Fragment, string: String) {
        listOfFragment.add(fragment)
        listOfFragmentStrings.add(string)
    }


    override fun getCount(): Int {
        return listOfFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return listOfFragment[position]

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listOfFragmentStrings[position]
    }


}