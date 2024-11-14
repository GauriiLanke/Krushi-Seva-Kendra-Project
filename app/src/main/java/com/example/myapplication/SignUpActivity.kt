package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
//import com.google.firebase.Firebase
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.auth

class SignUpActivity : AppCompatActivity() {
//    private lateinit var auth: FirebaseAuth
//    val signUpName=findViewById<TextView>(R.id.etSinUpName)
//    val signUpEmail=findViewById<TextView>(R.id.etSinUpEmail)
//    val signUpPass=findViewById<TextView>(R.id.etSinUpPassword)
//    val namee=findViewById<TextInputLayout>(R.id.tilName)
//    val emaill=findViewById<TextInputLayout>(R.id.tilEmail)
//    val pass=findViewById<TextInputLayout>(R.id.tilPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //auth= Firebase.auth

        val tvloginButton = findViewById<TextView>(R.id.tvLoginPage)
        tvloginButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

//        val signUp=findViewById<Button>(R.id.btnSignUp)
//        signUp.setOnClickListener{
//            registerUser()
//        }

    }

//    private fun registerUser(){
//        val name=signUpName.text.toString()
//        val email=signUpEmail.text.toString()
//        val password=signUpPass.text.toString()
//
//        if(validateForm(name,email,password)){
//            showProgressBar()
//            auth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener{task->
//                    if(task.isSuccessful){
//                        showToast(this,"User Id Created successfully")
//                        hideProgressBar()
//                        startActivity(Intent(this, MainActivity::class.java))
//                        finish()
//                    }
//                    else{
//                        showToast(this,"User Id not created.Try again later..")
//                        hideProgressBar()
//                    }
//
//                }
//        }
//
//    }
//
//    private fun validateForm(
//        name: kotlin.String,
//        email: kotlin.String,
//        password: kotlin.String
//    ): kotlin.Boolean {
//
//        return when{
//            namee.editText?.text.isNullOrEmpty()->{
//                namee.error="Enter name"
//                false
//            }
//            emaill.editText?.text.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emaill.editText?.text.toString()).matches()->{
//                emaill.error="Enter valid email address"
//                false
//            }
//            pass.editText?.text.isNullOrEmpty()->{
//                pass.error="Enter Password"
//                false
//            }
//
//            else -> {true}
//        }
}