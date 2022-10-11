package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homestay_uz.R
import com.example.homestay_uz.adapters.AdditionalsAdapter
import com.example.homestay_uz.models.Items

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView_itemViews: RecyclerView
    private var context: Context? = null

    private var menu: ImageView? = null
    private var search: ImageView? = null
    private var more: ImageView? = null

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

        menu = findViewById(R.id.main_menu_id)
        search = findViewById(R.id.main_search_id)
        more = findViewById(R.id.main_more_id)


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


}