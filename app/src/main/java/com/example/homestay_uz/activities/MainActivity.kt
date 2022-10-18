package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.ScreenAddsViewAdapter
import com.example.homestay_uz.adapters.ScreenViewAdapter
import com.example.homestay_uz.models.ScreenAddsView

import com.example.homestay_uz.models.ScreenView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewOfItemViews: RecyclerView
    private lateinit var recyclerViewOfAddsView: RecyclerView
    private var context: Context? = null
    private lateinit var searchForHomeStayOfTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        context = this

        recyclerViewOfItemViews = findViewById(R.id.recyclerview_main_horizontal)
        recyclerViewOfItemViews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewOfItemViews.isNestedScrollingEnabled = false


        recyclerViewOfAddsView = findViewById(R.id.recyclerview_main_vertical)
        recyclerViewOfAddsView.layoutManager = GridLayoutManager(this, 1)


        searchForHomeStayOfTextView = findViewById(R.id.searchForHomeStayTextView)
        searchForHomeStayOfTextView.setOnClickListener {
            openSearchPage()
        }


        refreshScreenViewAdapter(getScreenViewData())
        refreshScreenAddsViewAdapter(getScreenAddsViewData())
    }

    private fun getScreenAddsViewData(): ArrayList<ScreenAddsView> {
        val listOfScreenAddsView = ArrayList<ScreenAddsView>()

        for (index in 1..100) {
            listOfScreenAddsView.add(
                ScreenAddsView(
                    R.drawable.h, "Tashkent region Chirchik 5/60 home", "$150",
                    "Room size is 3,The rent house gets included in gas,water,bills and other facilities!"
                )
            )
        }

        return listOfScreenAddsView
    }

    private fun refreshScreenAddsViewAdapter(screenAddsViewData: ArrayList<ScreenAddsView>) {
        val adapter = ScreenAddsViewAdapter(this, screenAddsViewData)
        recyclerViewOfAddsView.adapter = adapter

    }

    private fun openSearchPage() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }

    private fun getScreenViewData(): ArrayList<ScreenView> {
        val listOfItems = ArrayList<ScreenView>()
        listOfItems.add(ScreenView("Weather", R.drawable.portrait))
        listOfItems.add(ScreenView("Hotels", R.drawable.portrait))
        listOfItems.add(ScreenView("Currency", R.drawable.portrait))
        listOfItems.add(ScreenView("Map", R.drawable.portrait))
        listOfItems.add(ScreenView("Items", R.drawable.portrait))
        return listOfItems
    }

    private fun refreshScreenViewAdapter(screenViewOfData: ArrayList<ScreenView>) {
        val adapter = ScreenViewAdapter(this, screenViewOfData)
        recyclerViewOfItemViews.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = this.menuInflater
        inflater.inflate(R.menu.navigationview_bottom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.bottom_menu_home_id -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            R.id.bottom_menu_favorite_id -> {
                val intent = Intent(this, Bottom_menu_favorite_Activity::class.java)
                startActivity(intent)
            }
            R.id.bottom_centre_rent_adds_menu_id -> {
                val intent = Intent(this, Bottom_menu_rent_adds_Activity::class.java)
                startActivity(intent)
            }
            R.id.bottom_menu_notification_id -> {
                val intent = Intent(this, Bottom_menu_notifications_Activity::class.java)
                startActivity(intent)
            }
            R.id.bottom_menu_more_horizontal_id -> {
                val intent = Intent(this, Bottom_menu_more_Activity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(menuItem)
    }

}