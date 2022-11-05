package com.example.homestay_uz.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.MainActivity
import com.example.homestay_uz.activities.ProfileActivity

class ProfileFragment : Fragment() {
    private lateinit var registerButton: Button
    private lateinit var backToMainActivity: ImageView
    companion object {
        fun newInstance() = ProfileFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

      //  initViews(view)
        return view

    }


    /***            <androidx.appcompat.widget.AppCompatButton
    android:id="@+id/profile_register_button_id"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:layout_marginTop="26sp"
    android:background="@drawable/background_views"
    android:hint="@string/register"
    android:singleLine="true"
    android:textAllCaps="false"
    android:textColorHint="#C1000000"
    android:textSize="16sp"
    android:textStyle="normal" />*/

    private fun initViews(view: View) {
     /*   registerButton =view.findViewById(R.id.profile_register_button_id)
        backToMainActivity = view.findViewById(R.id.profile_back_button_id)

        registerButton.setOnClickListener { openProfilePage() }
        backToMainActivity.setOnClickListener { backToMainMenu() }*/



    }

   /* private fun backToMainMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openProfilePage() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }*/

}