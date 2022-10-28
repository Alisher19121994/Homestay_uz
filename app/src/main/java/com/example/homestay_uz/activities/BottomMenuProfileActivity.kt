package com.example.homestay_uz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.homestay_uz.R

class BottomMenuProfileActivity : AppCompatActivity() {

    private lateinit var registerButton: Button
    private lateinit var backToMainActivity: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_menu_profile)
        initViews()
    }

    private fun initViews() {
        registerButton = findViewById(R.id.profile_register_button_id)
        backToMainActivity = findViewById(R.id.profile_back_button_id)

        registerButton.setOnClickListener { openProfilePage() }
        backToMainActivity.setOnClickListener { backToMainMenu() }

    }

    private fun backToMainMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openProfilePage() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}