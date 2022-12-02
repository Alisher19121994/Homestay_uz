package com.example.homestay_uz.activities.musicAndArt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homestay_uz.FragmentAdapters.ForAllFragmentsAdapter.EssentialFragmentAdapter
import com.example.homestay_uz.Fragments.history.EarlyHistoryFragment
import com.example.homestay_uz.Fragments.history.LaterHistoryFragment
import com.example.homestay_uz.Fragments.musicAndArt.NationaInstrumentlFragment
import com.example.homestay_uz.Fragments.musicAndArt.NationalArtFragment
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_music_and_art.*
import kotlinx.android.synthetic.main.fragment_uzbek_culture.*

class MusicAndArtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_and_art)
        initViews()
    }

    private fun initViews() {
        initFragments()

    }

    private fun initFragments() {

        val fragmentAdapter = EssentialFragmentAdapter(supportFragmentManager)

        fragmentAdapter.addToViewPager(NationaInstrumentlFragment(), "National Instrument")
        fragmentAdapter.addToViewPager(NationalArtFragment(), "National Art")


        viewPager_music_and_art_id.adapter = fragmentAdapter
        tabLayout_music_and_art_id.setupWithViewPager(viewPager_music_and_art_id)
    }
}