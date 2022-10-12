package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.AdditionalsAdapter
import com.example.homestay_uz.models.Items
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView_itemViews: RecyclerView
    private var context: Context? = null
    private var search: ImageView? = null
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        context = this

        recyclerView_itemViews = findViewById(R.id.recyclerview_main_horizontal)
        recyclerView_itemViews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_itemViews.isNestedScrollingEnabled = false

        search = findViewById(R.id.main_search_id)


        search?.setOnClickListener {
            openSearchPage()
        }


        // additionalItemsAdapter(dataOfAdditionalItems())

    }


    private fun openSearchPage() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }


    private fun dataOfAdditionalItems(): ArrayList<Items> {

        val listOfItems = ArrayList<Items>()


        listOfItems.add(Items("Weather", R.drawable.portrait))
        listOfItems.add(Items("Hotels", R.drawable.portrait))
        listOfItems.add(Items("Currency", R.drawable.portrait))
        listOfItems.add(Items("Map", R.drawable.portrait))
        listOfItems.add(Items("Items", R.drawable.portrait))


        return listOfItems

    }

    private fun additionalItemsAdapter(dataOfItems: ArrayList<Items>) {
        val adapter = AdditionalsAdapter(this, dataOfItems)
        recyclerView_itemViews.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = MenuInflater(context)
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