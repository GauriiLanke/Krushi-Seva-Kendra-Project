package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignUpActivity : AppCompatActivity() {
        public lateinit var auth: FirebaseAuth
        private lateinit var userName: String
        private lateinit var email: String
        private lateinit var password: String

        private lateinit var database: DatabaseReference
        private val binding: ActivitySignUpBinding by lazy {
            ActivitySignUpBinding.inflate(layoutInflater)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            auth= Firebase.auth
            database= Firebase.database.reference

            binding.btnSignUp.setOnClickListener{

                userName=binding.etSinUpName.text.toString().trim()
                email=binding.etSinUpEmail.text.toString().trim()
                password=binding.etSinUpPassword.text.toString().trim()
                if(userName.isBlank() || email.isBlank() || password.isBlank()){
                    Toast.makeText(this,"Please fill all details", Toast.LENGTH_SHORT).show()
                }
                else{
                    createAccount(email,password)
                }

            }
            binding.tvLoginPage.setOnClickListener{
                val intent= Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

        }

}

private fun SignUpActivity.createAccount(email: String, password: String) {
    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task->
        if(task.isSuccessful){
            Toast.makeText(this,"Account created successfully", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            Toast.makeText(this,"Account creation failed", Toast.LENGTH_SHORT).show()
            Log.d("Account","createAccount:Failed",task.exception)
        }
    }
}
