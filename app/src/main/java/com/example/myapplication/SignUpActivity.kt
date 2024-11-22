package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        binding.btnSignUp.setOnClickListener {
            val userName = binding.etSinUpName.text.toString().trim()
            val email = binding.etSinUpEmail.text.toString().trim()
            val password = binding.etSinUpPassword.text.toString().trim()

            if (userName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(userName, email, password)
            }
        }

        binding.tvLoginPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(userName: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserToDatabase(userName, email)
                val intent = Intent(this, DashBoardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
                Log.d("SignUpActivity", "createAccount: Failed", task.exception)
            }
        }
    }

    private fun saveUserToDatabase(userName: String, email: String) {
        val userId = auth.currentUser?.uid ?: return
        val user = mapOf("username" to userName, "email" to email)

        database.child("users").child(userId).setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("SignUpActivity", "User data saved to database")
            } else {
                Log.e("SignUpActivity", "Failed to save user data", task.exception)
            }
        }
    }
}
