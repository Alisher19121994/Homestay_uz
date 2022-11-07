package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.homestay_uz.R

class OnboardingActivity : AppCompatActivity() {


    private lateinit var skipTextView: TextView
    lateinit var registerTextView: TextView
    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        initViews()

    }

    private fun initViews() {
        skipTextView = findViewById(R.id.onBoarding_skip_id)
        registerTextView = findViewById(R.id.onBoarding_register_id)

        registerTextView.setOnClickListener {
            openPageMainActivity()
        }
        skipTextView.setOnClickListener {
            openMainActivity()

        }

    }

    private fun openPageMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    /**
     *        <LinearLayout
    android:layout_width="match_parent"
    android:layout_marginTop="90sp"
    android:layout_height="wrap_content">

    <androidx.appcompat.widget.AppCompatButton
    android:id="@+id/onBoarding_register_button_id"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:background="@drawable/background_views"
    android:gravity="center_horizontal|center_vertical"
    android:text="@string/register"
    android:textAllCaps="false"
    android:textColor="#000000"
    android:textSize="22sp"
    android:textStyle="normal" />
    </LinearLayout>**/
}