package com.example.homestay_uz.activities.initial

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.base.BaseActivity
import com.example.homestay_uz.manager.authManager.AuthManager

/***
 *
 *
 *
 *
 *
 *
 * **/
class SplashActivity : BaseActivity() {

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
        countDownTimer()

    }


    private fun countDownTimer() {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                if (AuthManager.isSignedIn()) {
                    openMainActivity(context)
                } else {
                    openSignInActivity(context)
                }

            }
        }.start()
    }
}