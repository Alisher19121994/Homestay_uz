package com.example.homestay_uz.manager.authManager

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object AuthManager {

     // var context: Context? = null
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var firebaseUser: FirebaseUser? = firebaseAuth.currentUser


    fun isSignedIn(): Boolean {
        return firebaseUser != null
    }

    fun signOut() {
        firebaseAuth.signOut()
    }

    fun signIn(email: String, password: String, authHandler: AuthHandler) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    authHandler.onSuccess()
                } else {
                    authHandler.onError(task.exception)
                }
            }
    }

    fun signUp(email: String, password: String, authHandler: AuthHandler) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    authHandler.onSuccess()
                } else {
                    authHandler.onError(task.exception)
                }
            }
    }

}