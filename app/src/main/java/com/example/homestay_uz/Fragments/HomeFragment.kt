package com.example.homestay_uz.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.SearchActivity
import com.example.homestay_uz.adapters.base_adapter.BaseScreenViewAdapter
import com.example.homestay_uz.models.base_model.BaseScreenViews
import com.example.homestay_uz.models.base_model.MainAdds
import com.example.homestay_uz.models.base_model.ScreenAddsView
import com.example.homestay_uz.models.base_model.ScreenView


class HomeFragment : Fragment() {
    private lateinit var recyclerViewOfHomeMenu: RecyclerView
    private lateinit var searchForSafeTourOfTextView: TextView

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View){

        val context :Context?=null
         recyclerViewOfHomeMenu = view.findViewById(R.id.home_fragment_recyclerview_id)
         recyclerViewOfHomeMenu.layoutManager = GridLayoutManager(context, 1)
         refreshBaseScreenViewAdapter(getBaseScreenViewData())
       // openSearchPage()
    }
   /* private fun openSearchPage() {
        searchForSafeTourOfTextView = findViewById(R.id.searchForSafeTourTextView)
        searchForSafeTourOfTextView.setOnClickListener {
            search()
        }
    }

    private fun search() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
    */
    private fun getBaseScreenViewData(): ArrayList<BaseScreenViews> {
        val listOfBaseScreenView = ArrayList<BaseScreenViews>()
        val listOfScreenView = ArrayList<ScreenView>()
        val listOfScreenAddsView = ArrayList<ScreenAddsView>()
        val mainAdds = MainAdds(R.drawable.home_screen)

        // listOfBaseScreenView.add(BaseScreenViews(mainAdds))

        listOfBaseScreenView.add(BaseScreenViews(listOfScreenView))
        listOfScreenView.add(ScreenView("Hotels", R.drawable.portrait))
        listOfScreenView.add(ScreenView("Weather", R.drawable.portrait))
        listOfScreenView.add(ScreenView("Currency", R.drawable.portrait))
        listOfScreenView.add(ScreenView("Online ticket", R.drawable.portrait))
        listOfScreenView.add(ScreenView("Map", R.drawable.portrait))
        listOfScreenView.add(ScreenView("Transport", R.drawable.portrait))


        for (i in 1..10) {
            listOfBaseScreenView.add(
                BaseScreenViews(
                    ScreenAddsView(
                        R.drawable.h,
                        "Tashkent city, chilanzar district,home address 5/60",
                        "$150",
                        "Room size is 3,The rent house gets included in gas,water,bills and other facilities!"
                    )
                )
            )
        }
        return listOfBaseScreenView
    }

    private fun refreshBaseScreenViewAdapter(baseScreenViewData: ArrayList<BaseScreenViews>) {

        val adapter = context?.let { BaseScreenViewAdapter(it, baseScreenViewData) }
        recyclerViewOfHomeMenu.adapter = adapter

    }



}