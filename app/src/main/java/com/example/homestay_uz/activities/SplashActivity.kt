package com.example.homestay_uz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.example.homestay_uz.R

class SplashActivity : AppCompatActivity() {
    private var context: Context? = null
    private var splashTextName: TextView? = null
    private var splashLottieAnimationView: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        initViews()

    }

    private fun initViews() {

        context = this

        splashTextName?.animate()?.translationY(-1400f)?.setDuration(2700)?.startDelay = 0
        splashLottieAnimationView?.animate()?.translationX(2000f)?.setDuration(2000)?.startDelay = 2900

        Handler().postDelayed({
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()

        }, 4000)

    }
}