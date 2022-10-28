package com.example.homestay_uz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.homestay_uz.R

class SearchActivity : AppCompatActivity() {
    lateinit var searchBackToMainPage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        initViews()
    }

    private fun initViews() {
        searchBackToMainPage = findViewById(R.id.search_back_to_main_page)
        searchBackToMainPage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}