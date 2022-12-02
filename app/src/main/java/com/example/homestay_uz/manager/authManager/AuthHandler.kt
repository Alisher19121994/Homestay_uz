package com.example.homestay_uz.manager.authManager

interface AuthHandler {

    fun onSuccess()
    fun onError(exception: java.lang.Exception?)
}