package com.example.homestay_uz.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.homestay_uz.R
import com.example.homestay_uz.utils.Extensions.toast

/***
 *
 *
 *
 *
 *
 * **/
class CallPhone : BaseActivity() {
    private var REQUEST_CALL = 101
    private lateinit var numberEditText: EditText
    lateinit var calledImageView: ImageView
    private var canceledImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.call_phone)
        initViews()
    }

    private fun initViews() {

        numberEditText = findViewById(R.id.number_call_edittext_view_id)
        calledImageView = findViewById(R.id.make_phone_call_imageview_id)
        canceledImageView = findViewById(R.id.cancel_phone_call_imageview_id)

        calledImageView.setOnClickListener {
            makePhoneCall()
        }

        canceledImageView?.setOnClickListener {
            finish()
        }
    }


    private fun makePhoneCall() {
        val number = numberEditText.text.toString().trim()

        if (number.length > 0) {
            //val intent = Intent(Intent.ACTION_CALL)
            //intent.data = Uri.parse(number)
            // startActivity(intent)

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CALL
                )
            } else {

                val dial = "Dial: $number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))

            }
        } else {
            toast("Number must not be empty!")
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CALL) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall()
            }else{
                toast("Not allowed!")
            }
        }

    }


}