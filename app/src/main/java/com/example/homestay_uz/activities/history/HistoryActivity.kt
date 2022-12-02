package com.example.homestay_uz.activities.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homestay_uz.FragmentAdapters.ForAllFragmentsAdapter.EssentialFragmentAdapter
import com.example.homestay_uz.Fragments.foods.MantiFragment
import com.example.homestay_uz.Fragments.foods.OshFragment
import com.example.homestay_uz.Fragments.foods.SomsaFragment
import com.example.homestay_uz.Fragments.foods.SumalakFragment
import com.example.homestay_uz.Fragments.history.EarlyHistoryFragment
import com.example.homestay_uz.Fragments.history.LaterHistoryFragment
import com.example.homestay_uz.Fragments.modernUzbekistan.EarlyFragment
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.activity_foods.*
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.fragment_uzbek_culture.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        initViews()
    }

    private fun initViews() {
      initFragments()

    }

    private fun initFragments() {

        val fragmentAdapter = EssentialFragmentAdapter(supportFragmentManager)

        fragmentAdapter.addToViewPager(EarlyHistoryFragment(), "Early")
        fragmentAdapter.addToViewPager(LaterHistoryFragment(), "Later")


        viewPager_history_id.adapter = fragmentAdapter
        tabLayout_history_id.setupWithViewPager(viewPager_history_id)
    }
}