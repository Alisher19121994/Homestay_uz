package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.homestay_uz.FragmentAdapters.FragmentAdapter
import com.example.homestay_uz.Fragments.FavoriteFragment
import com.example.homestay_uz.Fragments.HomeFragment
import com.example.homestay_uz.Fragments.ProfileFragment
import com.example.homestay_uz.Fragments.UzbekCultureFragment
import com.example.homestay_uz.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var context: Context? = null

    private lateinit var viewPager: ViewPager
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var menuItem: MenuItem

    private lateinit var floatingPoliceButton: FloatingActionButton
    private lateinit var floatingMedicalButton: FloatingActionButton
    private lateinit var floatingMainButton: FloatingActionButton
    private var isPressedFloatingButton: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        context = this
        initFragments()
        getFloatingData()
    }


    private fun getFloatingData() {
        floatingMainButton = findViewById(R.id.floating_button_main_xlm_id)
        floatingMedicalButton = findViewById(R.id.floating_button_medical_xlm_id)
        floatingPoliceButton = findViewById(R.id.floating_button_police_xlm_id)

        floatingMedicalButton.setOnClickListener {
            infoDialogForEmergencyToMedicine()
        }
        floatingPoliceButton.setOnClickListener {
            infoDialogForEmergencyToPolice()
        }


        floatingMainButton.setOnClickListener {
            isPressedFloatingButton = if (isPressedFloatingButton) {
                floatingMedicalButton.show()
                floatingPoliceButton.show()
                false
            } else {
                floatingMedicalButton.hide()
                floatingPoliceButton.hide()
                true

            }
        }
    }

    private fun infoDialogForEmergencyToMedicine() {
        AlertDialog.Builder(this)
            .setTitle("Emergency call")
            .setMessage("Medical aid!\n \nDo you need to phone call?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->

            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.cancel()
            }
            .setIcon(R.drawable.ic_baseline_local_phone_24)
            .show()

    }

    private fun infoDialogForEmergencyToPolice() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_baseline_local_phone_24)
            .setTitle("Emergency call")
            .setMessage("Tour Police aid!\n \nDo you need to phone call?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->
            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.cancel()
            }
            .show()
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