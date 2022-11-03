package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.homestay_uz.FragmentAdapters.FragmentAdapter
import com.example.homestay_uz.Fragments.FavoriteFragment
import com.example.homestay_uz.Fragments.HomeFragment
import com.example.homestay_uz.Fragments.ProfileFragment
import com.example.homestay_uz.Fragments.UzbekCultureFragment
import com.example.homestay_uz.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var context: Context? = null
    private lateinit var searchForSafeTourOfTextView: TextView
    lateinit var viewPager: ViewPager
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this
        initFragments()
        openSearchPage()

    }

    private fun openSearchPage() {
        searchForSafeTourOfTextView = findViewById(R.id.searchForSafeTourTextView)
        searchForSafeTourOfTextView.setOnClickListener {
            search()
        }
    }

    private fun search() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }

    private fun initFragments() {
        viewPager = findViewById(R.id.viewpager_main_activity_id)
        bottomNavigationView = findViewById(R.id.bottom_navigation_id)

        val fragmentAdapter = FragmentAdapter(fragmentData(), supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        bottomNavigationView.setOnNavigationItemSelectedListener { bottomMenuId ->

            when (bottomMenuId.itemId) {

                R.id.bottom_menu_home_id -> {
                    viewPager.currentItem = 0
                }

                R.id.bottom_menu_favorite_id -> {
                    viewPager.currentItem = 1
                }

                R.id.bottom_uzbek_culture_menu_id -> {
                    viewPager.currentItem = 2
                }

                R.id.bottom_menu_profile_id -> {
                    viewPager.currentItem = 3
                }

            }
            true
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                if (::menuItem.isInitialized) {
                    menuItem.isChecked = false
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false

                }
                bottomNavigationView.menu.getItem(position).isChecked = true
                menuItem = bottomNavigationView.menu.getItem(position)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        }
        )
    }

    private fun fragmentData(): ArrayList<Fragment> {
        return arrayListOf(
            HomeFragment.newInstance(),
            FavoriteFragment.newInstance(),
            UzbekCultureFragment.newInstance(),
            ProfileFragment.newInstance()
        )
    }


}