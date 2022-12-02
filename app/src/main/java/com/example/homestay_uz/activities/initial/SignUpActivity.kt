package com.example.homestay_uz.activities.initial

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.base.BaseActivity
import com.example.homestay_uz.activities.base.MainActivity
import com.example.homestay_uz.manager.authManager.AuthHandler
import com.example.homestay_uz.manager.authManager.AuthManager
import com.example.homestay_uz.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

/**
 *
 *
 *
 *
 *
 * **/
class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViews()
    }

    private fun initViews() {
        val email = email_edittext_into_sign_up_id.text.toString().trim()
        val password = password_edittext_into_sign_up_id.text.toString().trim()
        firebaseAuth(email, password)
    }

    private fun firebaseAuth(email: String, password: String) {
        showLoading(this)
        AuthManager.signUp(email,password,object :AuthHandler{
            override fun onSuccess() {
                dismissLoading()
                openSignInActivity(context)
                toast("Signed in!")
            }

            override fun onError(exception: Exception?) {
                dismissLoading()
                toast("Error!")
            }
        })
    }
}