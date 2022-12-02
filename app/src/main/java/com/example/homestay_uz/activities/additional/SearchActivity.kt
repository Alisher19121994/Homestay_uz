package com.example.homestay_uz.activities.additional

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.homestay_uz.R
import java.net.URL
/**
 *
 *
 *
 *
 *
 *
 * **/
class SearchActivity : AppCompatActivity() {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var webView: WebView
    private var url = "https://www.google.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.google_search)
        initViews()
    }

    private fun initViews() {
        googleSearch()

    }

    @SuppressLint("WebViewApiAvailability", "SuspiciousIndentation")
    private fun googleSearch() {

        swipeRefreshLayout = findViewById(R.id.swipe_id)
        webView = findViewById(R.id.webview_id)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webView.webViewClient
        }

        webView.loadUrl(url)
        swipeRefreshLayout.isRefreshing = false

    }
}