package com.example.homestay_uz.Fragments.menuFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.additional.SearchActivity
import com.example.homestay_uz.activities.foods.FoodsActivity
import com.example.homestay_uz.activities.history.HistoryActivity
import com.example.homestay_uz.activities.modernUzbekistan.ModernUzbekistanActivity
import com.example.homestay_uz.activities.musicAndArt.MusicAndArtActivity
import kotlinx.android.synthetic.main.fragment_uzbek_culture.*
import kotlinx.android.synthetic.main.fragment_uzbek_culture.view.*
/**
 *
 * AIzaSyB9IsCrpZPbfkbaTLcH87xvoB4aSwTB95Y
 *
 * **/
class UzbekCultureFragment : Fragment() {

    companion object {
        fun newInstance() = UzbekCultureFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_uzbek_culture, container, false)
        initViews(view)
        return view
    }


    private fun initViews(view: View) {
        googleSearchPage(view)
        openNewPage(view)

    }

    private fun openNewPage(view: View) {
        view.modern_uzbekistan_id.setOnClickListener {
            openModernUzbekistanActivity()
        }

        view.foods_id.setOnClickListener {
            openFoodsActivity()
        }

        view.history_id.setOnClickListener {
            openHistoryActivity()
        }

        view.modern_art_culture_id.setOnClickListener {
            openMusicAndArtActivity()
        }
    }

    private fun openModernUzbekistanActivity() {
        val intent = Intent(activity, ModernUzbekistanActivity::class.java)
        startActivity(intent)
    }

    private fun openHistoryActivity() {
        val intentHistory = Intent(activity, HistoryActivity::class.java)
        startActivity(intentHistory)
    }

    private fun openMusicAndArtActivity() {
        val intentMusic = Intent(activity, MusicAndArtActivity::class.java)
        startActivity(intentMusic)
    }

    private fun openFoodsActivity() {
        val intentFoods = Intent(activity, FoodsActivity::class.java)
        startActivity(intentFoods)
    }

    private fun googleSearchPage(view: View){
        view.google_search_id.setOnClickListener {
            val intent = Intent(view.context, SearchActivity::class.java)
            startActivity(intent)
        }


    }




}