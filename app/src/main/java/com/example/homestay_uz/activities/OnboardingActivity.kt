package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.homestay_uz.FragmentAdapters.Onboarding
import com.example.homestay_uz.Fragments.FoundRentHouseFragment
import com.example.homestay_uz.Fragments.LivingAtHomeFragment
import com.example.homestay_uz.Fragments.SearchingHomesFragment
import com.example.homestay_uz.R
import com.google.android.material.tabs.TabLayout

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var button_onboarding: Button
    private lateinit var onboarding: Onboarding
    private var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        initViews()

    }

    private fun initViews() {
        context = this

        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tablayout)
        button_onboarding = findViewById(R.id.button_onboarding_id)

        onboarding = Onboarding(supportFragmentManager)

        onboarding.addFragmentLists(SearchingHomesFragment(), "Searching...")
        onboarding.addFragmentLists(FoundRentHouseFragment(), "Find out Rents")
        onboarding.addFragmentLists(LivingAtHomeFragment(), "Residence")

        viewPager.adapter = onboarding

        tabLayout.setupWithViewPager(viewPager)


        button_onboarding.setOnClickListener {
            openMainActivity()
        }

    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}