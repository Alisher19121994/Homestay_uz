package com.example.homestay_uz.Fragments.foods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homestay_uz.R

/**
 * A simple [Fragment] subclass.
 * Use the [MantiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MantiFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manti, container, false)
    }


}