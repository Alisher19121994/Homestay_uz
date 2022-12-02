package com.example.homestay_uz.Fragments.menuFragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.homestay_uz.R
import com.example.homestay_uz.activities.additional.ProfileActivity

class ProfileFragment : Fragment() {

    private var saveButtonTextView: TextView?=null


    companion object {
        fun newInstance() = ProfileFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

       // initViews(view)
        return view

    }

    private fun initViews(view: View) {
        val context :Context? = null
        saveButtonTextView =view.findViewById(R.id.profile_register_id)
        saveButtonTextView?.setOnClickListener{
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)


        }




    }

}