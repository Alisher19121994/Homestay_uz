package com.example.homestay_uz.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
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

    private fun initViews(view: View) {

        val context: Context? = null
        recyclerViewOfHomeMenu = view.findViewById(R.id.home_fragment_recyclerview_id)
        recyclerViewOfHomeMenu.layoutManager = GridLayoutManager(context, 1)
        refreshBaseScreenViewAdapter(getBaseScreenViewData())
    }

    private fun getBaseScreenViewData(): ArrayList<BaseScreenViews> {
        val listOfBaseScreenView = ArrayList<BaseScreenViews>()
        val listOfScreenView = ArrayList<ScreenView>()
        val listOfScreenAddsView = ArrayList<ScreenAddsView>()


        for (i in 1..100) {
            when (i) {
                1 -> {
                    val mainAdds = MainAdds(R.drawable.home_screen)
                      //listOfBaseScreenView.add(BaseScreenViews(mainAdds))
                }
                2 -> {

                    listOfBaseScreenView.add(BaseScreenViews(listOfScreenView))
                    listOfScreenView.add(ScreenView("Hotels", R.drawable.portrait))
                    listOfScreenView.add(ScreenView("Weather", R.drawable.portrait))
                    listOfScreenView.add(ScreenView("Online ticket", R.drawable.portrait))
                    listOfScreenView.add(ScreenView("Location", R.drawable.portrait))
                    listOfScreenView.add(ScreenView("Transportation", R.drawable.portrait))

                    /*listOfBaseScreenView.add(BaseScreenViews(listOfScreenView))
                    listOfScreenView.add(ScreenView("Hotels", R.raw.hotel))
                    listOfScreenView.add(ScreenView("Weather", R.raw.weather))
                    listOfScreenView.add(ScreenView("Online ticket", R.raw.ticket))
                    listOfScreenView.add(ScreenView("Location", R.raw.map))
                    listOfScreenView.add(ScreenView("Transportation", R.raw.transportation))*/
                }
                else -> {
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
            }
        }
        return listOfBaseScreenView
    }

    private fun refreshBaseScreenViewAdapter(baseScreenViewData: ArrayList<BaseScreenViews>) {

        val adapter = context?.let { BaseScreenViewAdapter(it, baseScreenViewData) }
        recyclerViewOfHomeMenu.adapter = adapter

    }


}