package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
import com.google.android.material.navigation.NavigationView
import java.util.jar.Manifest
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var context: Context? = null

    private var REQUEST_CALL = 1

    private lateinit var viewPager: ViewPager
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var menuItem: MenuItem

    private lateinit var floatingPoliceButton: FloatingActionButton
    private lateinit var floatingMedicalButton: FloatingActionButton
    private lateinit var floatingMainButton: FloatingActionButton
    private var isPressedFloatingButton: Boolean = true


    private lateinit var moreButton: NavigationView


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
            .setMessage("Medical aid!\n" +
                    "Number is 103\n \nDo you need to phone call?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->

                makePhoneCallToMedicine()
            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.cancel()
            }
            .setIcon(R.drawable.ic_baseline_local_phone_24)
            .show()

    }


  /*  override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCallToMedicine()
            } else {
                Toast.makeText(this, "unavailable to call", Toast.LENGTH_SHORT).show()
            }
        }

    }*/


    private fun makePhoneCallToMedicine() {
        
        val number = "103"
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse(number)))



       /* if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                REQUEST_CALL
            )
        } else {
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(number)))
            Toast.makeText(this, "Calling...", Toast.LENGTH_SHORT).show()
        }*/

    }


    private fun infoDialogForEmergencyToPolice() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_baseline_local_phone_24)
            .setTitle("Emergency call")
            .setMessage("Tour Police aid! \nNumber is 102\n \nDo you need to phone call?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->
            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.cancel()
            }
            .show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        val getMenu = MenuInflater(this)
        getMenu.inflate(R.menu.more_data, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.more_menu_language_id -> {
                Toast.makeText(this, "Language clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.english_id -> {
                Toast.makeText(this, "english clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.southkorean_id -> {
                Toast.makeText(this, "korean clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.log_out_id -> {
                Toast.makeText(this, "log out clicked", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
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