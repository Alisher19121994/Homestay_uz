package com.example.homestay_uz.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.base_adapter.BaseScreenViewAdapter
import com.example.homestay_uz.adapters.base_adapter.favorite_adapter.FavoriteAdapter
import com.example.homestay_uz.models.base_model.BaseScreenViews
import com.example.homestay_uz.models.base_model.MainAdds
import com.example.homestay_uz.models.base_model.ScreenAddsView
import com.example.homestay_uz.models.base_model.ScreenView
import com.example.homestay_uz.models.favorite_model.Favorites

class FavoriteFragment : Fragment() {

    private lateinit var recyclerViewOfFavorite: RecyclerView

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {

        val context: Context? = null
        recyclerViewOfFavorite = view.findViewById(R.id.favorite_main_recyclerview_id)
        recyclerViewOfFavorite.layoutManager = LinearLayoutManager(context)
        refreshFavoriteAdapter(getFavoriteData())

    }

    private fun getFavoriteData(): ArrayList<Favorites> {
        val favoritesOfList = ArrayList<Favorites>()
        val favorites = Favorites(
            R.drawable.h, "Tashkent city, chilanzar district,home address 5/60", "$150",
            "Room size is 3,The rent house gets included in gas,water,bills and other facilities!"
        )
        for (index in 1..15) {
            favoritesOfList.add(favorites)
        }

        return favoritesOfList
    }

    private fun refreshFavoriteAdapter(favorites: ArrayList<Favorites>) {

        val adapter = FavoriteAdapter(favorites)
        recyclerViewOfFavorite.adapter = adapter

    }


}