package com.example.homestay_uz.activities.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.additional.CallPhone
import com.example.homestay_uz.activities.initial.SignInActivity
import com.example.homestay_uz.activities.initial.SignUpActivity

/**
 *
 *
 *
 *
 * **/
open class BaseActivity : AppCompatActivity() {

    var progressDialog: AppCompatDialog? = null
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }

    fun showLoading(activity: Activity?) {
        if (activity == null) return

        if (progressDialog != null && progressDialog!!.isShowing) {

        } else {
            progressDialog = AppCompatDialog(activity, R.style.CustomDialog)
            progressDialog!!.setCancelable(false)
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog!!.setContentView(R.layout.custom_progress_dialog)

            val progress = progressDialog!!.findViewById<ImageView>(R.id.iv_progress_id)
            val animationDrawable = progress!!.drawable as AnimationDrawable
            animationDrawable.start()

            if (activity.isFinishing) progressDialog!!.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissLoading()
    }

     fun dismissLoading() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    }


    fun openMainActivity(context: Context){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun openSignInActivity(context: Context){
        val intent = Intent(context, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun openSignUnActivity(context: Context){
        val intent = Intent(context, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun openCallPhoneActivity(context: Context){
        val intent = Intent(context, CallPhone::class.java)
        startActivity(intent)

    }

}