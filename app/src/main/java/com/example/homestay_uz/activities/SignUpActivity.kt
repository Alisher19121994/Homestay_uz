package com.example.homestay_uz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homestay_uz.R

class SignUpActivity : BaseActivity() {
    lateinit var signUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViews()
    }

    private fun initViews() {
        signUp = findViewById(R.id.sign_up_textview_button_into_sign_up_id)
        signUp.setOnClickListener {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        }
    }
}