package com.example.homestay_uz.activities.initial

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.base.BaseActivity
import com.example.homestay_uz.manager.authManager.AuthHandler
import com.example.homestay_uz.manager.authManager.AuthManager
import com.example.homestay_uz.utils.Extensions.toast
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.lang.Exception

/**
 * **/
class SignInActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()
    }

    private fun initViews() {

        val email = email_edittext_into_sign_in_id.text.toString().trim()
        val password = password_edittext_into_sign_in_id.text.toString().trim()

        firebaseSignIn(email, password)
        openSignUPage()
    }

    private fun openSignUPage() {
        sign_up_bellow_into_sign_in_button_id.setOnClickListener {
            openSignUnActivity(context)
        }
    }

    private fun firebaseSignIn(email: String, password: String) {
        showLoading(this)
        AuthManager.signIn(email, password, object : AuthHandler {
            override fun onSuccess() {
                dismissLoading()
                openMainActivity(context)
                toast("Successfully signed in!")
            }

            override fun onError(exception: Exception?) {
                dismissLoading()
                toast("Error!")
            }
        })
    }
}