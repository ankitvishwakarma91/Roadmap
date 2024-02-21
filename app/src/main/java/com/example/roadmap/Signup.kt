package com.example.roadmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val SignUpButton = findViewById<Button>(R.id.btnsignUpPage)
        val emailText = findViewById<EditText>(R.id.emailAddress)
        val passwordText = findViewById<EditText>(R.id.textInputEditText)
        val mobileNumber = findViewById<EditText>(R.id.textInputEditText2)
        val Signin = findViewById<TextView>(R.id.textView7)

        Signin.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

        SignUpButton.setOnClickListener {
            val email = emailText.text.toString()
            val password = passwordText.text.toString()
            val mobileNumberCode = mobileNumber.text.toString()

            val user = Data(email,password,mobileNumberCode)
            database = FirebaseDatabase.getInstance().reference
            database.child(mobileNumberCode).setValue(user).addOnSuccessListener {
                Toast.makeText(this ,"Register Successful",Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }

    }
}