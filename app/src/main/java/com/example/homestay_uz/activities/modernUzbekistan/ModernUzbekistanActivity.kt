package com.example.homestay_uz.activities.modernUzbekistan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homestay_uz.FragmentAdapters.ForAllFragmentsAdapter.EssentialFragmentAdapter
import com.example.homestay_uz.Fragments.history.EarlyHistoryFragment
import com.example.homestay_uz.Fragments.history.LaterHistoryFragment
import com.example.homestay_uz.Fragments.modernUzbekistan.CurrentFragment
import com.example.homestay_uz.Fragments.modernUzbekistan.EarlyFragment
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_modern_uzbekistan.*
import kotlinx.android.synthetic.main.fragment_uzbek_culture.*

class ModernUzbekistanActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modern_uzbekistan)
        initViews()
    }

    private fun initViews() {
     initFragments()

    }

    private fun initFragments() {

        val fragmentAdapter = EssentialFragmentAdapter(supportFragmentManager)

        fragmentAdapter.addToViewPager(CurrentFragment(), "Current")
        fragmentAdapter.addToViewPager(EarlyFragment(), "Early")


        viewPager_modern_uzbekistan_id.adapter = fragmentAdapter
        tabLayout_modern_uzbekistan_id.setupWithViewPager(viewPager_modern_uzbekistan_id)
    }
}