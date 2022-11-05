package com.example.homestay_uz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.homestay_uz.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        registerButton = findViewById(R.id.new_page_profile_adds_button_id)
        registerButton.setOnClickListener { openProfilePage() }

    }


    private fun openProfilePage() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}