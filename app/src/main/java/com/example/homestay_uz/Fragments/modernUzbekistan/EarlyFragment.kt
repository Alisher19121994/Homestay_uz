package com.example.homestay_uz.Fragments.modernUzbekistan

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.homestay_uz.R
import kotlinx.android.synthetic.main.fragment_early.*
import kotlinx.android.synthetic.main.fragment_early.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [EarlyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EarlyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_early, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        youtubeData1(view)
        youtubeData2(view)
    }

    @SuppressLint("WebViewApiAvailability", "SuspiciousIndentation")
    private fun youtubeData1(view: View) {

        val url = "https://www.youtube.com/watch?v=BB4-i0PHEg8"
        view.linear1_id.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                view.webView_moder_uzb_sovet_era_id.webViewClient
            }
            view.webView_moder_uzb_sovet_era_id.loadUrl(url)

        }
    }



    @SuppressLint("WebViewApiAvailability", "SuspiciousIndentation")
    private fun youtubeData2(view: View) {

        val url = "https://www.youtube.com/"

        view.linear1_id.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                view.webView_moder_uzb_sovet_era_id.webViewClient
            }
            view.webView_moder_uzb_sovet_era_id.loadUrl(url)

        }
    }


}