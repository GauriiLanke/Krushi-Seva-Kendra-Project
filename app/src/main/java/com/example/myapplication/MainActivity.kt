package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        GlobalScope.launch(Dispatchers.Main){
            delay(3000)
            val intent= Intent(this@MainActivity, GetStartedActivity::class.java)
            startActivity(intent)
            finish()
        }
        val database = FirebaseDatabase.getInstance()
        val testRef = database.getReference("testKey")
        testRef.setValue("TestValue").addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("FirebaseTest", "Test write successful")
            } else {
                Log.e("FirebaseTest", "Test write failed", task.exception)
            }
        }

    }
}
