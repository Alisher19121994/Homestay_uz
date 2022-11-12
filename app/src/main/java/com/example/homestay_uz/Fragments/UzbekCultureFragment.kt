package com.example.homestay_uz.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.SearchActivity

class UzbekCultureFragment : Fragment() {

    lateinit var googleSearch: LinearLayout

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
    }


    private fun googleSearchPage(view: View){
        googleSearch = view.findViewById(R.id.google_search_id)
        googleSearch.setOnClickListener {
            val intent = Intent(view.context,SearchActivity::class.java)
            startActivity(intent)
        }


    }




}