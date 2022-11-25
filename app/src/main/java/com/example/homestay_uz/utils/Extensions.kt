package com.example.homestay_uz.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

object Extensions {
    fun Activity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}