package com.example.homestay_uz.activities.foods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homestay_uz.FragmentAdapters.ForAllFragmentsAdapter.EssentialFragmentAdapter
import com.example.homestay_uz.Fragments.foods.MantiFragment
import com.example.homestay_uz.Fragments.foods.OshFragment
import com.example.homestay_uz.Fragments.foods.SomsaFragment
import com.example.homestay_uz.Fragments.foods.SumalakFragment
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.activity_foods.*
import kotlinx.android.synthetic.main.fragment_uzbek_culture.*

class FoodsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)

        initViews()
    }

    private fun initViews() {
        initFragments()

    }

    private fun initFragments() {

        val fragmentAdapter = EssentialFragmentAdapter(supportFragmentManager)

        fragmentAdapter.addToViewPager(MantiFragment(), "Manti")
        fragmentAdapter.addToViewPager(OshFragment(), "Plaw")
        fragmentAdapter.addToViewPager(SomsaFragment(), "Somsa")
        fragmentAdapter.addToViewPager(SumalakFragment(), "Sumalak")

        viewPager_foods_id.adapter = fragmentAdapter
        tabLayout_foods_id.setupWithViewPager(viewPager_foods_id)
    }
}