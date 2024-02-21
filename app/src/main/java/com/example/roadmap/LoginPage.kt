package com.example.roadmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var databaseReference: DatabaseReference


class LoginPage : AppCompatActivity() {
    companion object{
        const val KEY = "com.example.roadmap.KEY.uniquemail"
        const val KEY1 = "com.example.roadmap.KEY1.mobileNumber"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initialize database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Data")

        val signUpTextView = findViewById<TextView>(R.id.textView10)
        val loginButton = findViewById<Button>(R.id.button3)
        val emailLogin = findViewById<TextInputEditText>(R.id.emailLogin)
        val passwordLogin = findViewById<TextInputEditText>(R.id.passowrdLogin)

        signUpTextView.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val uniqueMail = emailLogin.text.toString()
            val password = passwordLogin.text.toString()

            if (uniqueMail.isNotEmpty() && password.isNotEmpty()) {
                // Perform login operation
                login(uniqueMail, password)

            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @OptIn(UnstableApi::class) private fun login(uniqueMail: String, password: String) {
        databaseReference.child(uniqueMail).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                // User exists, you might want to compare passwords here
                val child = snapshot.child("email").value
                val intentWelcome = Intent(this, EnteringPage::class.java)
                intentWelcome.putExtra(KEY, uniqueMail)
                startActivity(intentWelcome)
            } else {
                Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            // Log the actual exception for debugging purposes
            Log.e("LoginPage", "Error logging in: ${it.message}", it)
            Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show()
        }
    }


}
