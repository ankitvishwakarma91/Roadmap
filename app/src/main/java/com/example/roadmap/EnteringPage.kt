package com.example.roadmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EnteringPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entering_page)

        val email = intent.getStringArrayExtra(LoginPage.KEY)


        val emailShow = findViewById<TextView>(R.id.emailText)
//        val mobileNumberShow = findViewById<TextView>(R.id.mobileNumberText)

        emailShow.text = "This is you email $email"

    }
}