package com.example.roadmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SignUpPage = findViewById<Button>(R.id.btnsignup)
        val LoginPageOpen = findViewById<Button>(R.id.btnLogin)

        SignUpPage.setOnClickListener {
            val intent = Intent(applicationContext,Signup::class.java)
            startActivity(intent)
        }

        LoginPageOpen.setOnClickListener {
            val intent = Intent(applicationContext,LoginPage::class.java)
            startActivity(intent)
        }
    }
}