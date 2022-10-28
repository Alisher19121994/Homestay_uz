package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.BaseScreenViewAdapter
import com.example.homestay_uz.models.BaseScreenViews
import com.example.homestay_uz.models.ScreenAddsView

import com.example.homestay_uz.models.ScreenView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var context: Context? = null
    private lateinit var recyclerViewOfItemViews: RecyclerView
    private lateinit var searchForHomeStayOfTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        context = this

        recyclerViewOfItemViews = findViewById(R.id.recyclerview_main_vertical)
        recyclerViewOfItemViews.layoutManager = GridLayoutManager(this, 1)


        searchForHomeStayOfTextView = findViewById(R.id.searchForHomeStayTextView)
        searchForHomeStayOfTextView.setOnClickListener {
            openSearchPage()
        }


        refreshBaseScreenViewAdapter(getBaseScreenViewData())
    }

    private fun getBaseScreenViewData(): ArrayList<BaseScreenViews> {
        val listOfBaseScreenView = ArrayList<BaseScreenViews>()
        val listOfScreenView = ArrayList<ScreenView>()
        val listOfScreenAddsView = ArrayList<ScreenAddsView>()

        listOfBaseScreenView.add(BaseScreenViews(listOfScreenView))
        for (i in 1..10) {
            listOfScreenView.add(ScreenView("Weather", R.drawable.portrait))
        }

        //listOfBaseScreenView.add(BaseScreenViews(listOfScreenAddsView))
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
        val adapter = BaseScreenViewAdapter(this, baseScreenViewData)
        recyclerViewOfItemViews.adapter = adapter

    }

    private fun openSearchPage() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = this.menuInflater
        inflater.inflate(R.menu.navigationview_bottom_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.bottom_menu_home_id -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            }

            R.id.bottom_menu_favorite_id -> {
                val intent = Intent(this, Bottom_menu_favorite_Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            }
            R.id.bottom_centre_rent_adds_menu_id -> {
                val intent = Intent(this, Bottom_menu_rent_adds_Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            }
            R.id.bottom_menu_notification_id -> {
                val intent = Intent(this, Bottom_menu_notifications_Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            }
            R.id.bottom_menu_profile_id -> {
                val intent = Intent(this, BottomMenuProfileActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            }

        }
        return super.onOptionsItemSelected(menuItem)
    }

}