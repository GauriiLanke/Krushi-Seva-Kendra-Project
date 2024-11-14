package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val loginButton = findViewById<TextView>(R.id.tvRegister)
        loginButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val forgetButton = findViewById<TextView>(R.id.tvForgotPassword)
        forgetButton.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        //Static validation of email,password
        val loginn=findViewById<AppCompatButton>(R.id.btnSignIn)
        val signInEmail=findViewById<EditText>(R.id.etSinInEmail)
        val signInPass=findViewById<EditText>(R.id.etSinInPassword)

        loginn.setOnClickListener{
            val email=signInEmail.text.toString()
            val password=signInPass.text.toString()
            if(email=="abcd@gmail.com" && password=="hello@123"){
                val intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong credentials", Toast.LENGTH_SHORT).show()
            }

        }

    }
}