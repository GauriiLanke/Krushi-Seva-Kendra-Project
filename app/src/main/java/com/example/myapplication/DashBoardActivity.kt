package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        findViewById<CardView>(R.id.cvProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        findViewById<CardView>(R.id.cvProductCatalogue).setOnClickListener {
            startActivity(Intent(this, ProductCatalogueActivity::class.java))
        }

        findViewById<CardView>(R.id.cvOnlinePurchasing).setOnClickListener {
            startActivity(Intent(this, OnlinePurchasingActivity::class.java))
        }

        findViewById<CardView>(R.id.cvFeedback).setOnClickListener {
            startActivity(Intent(this, FeedbackActivity::class.java))
        }

        findViewById<CardView>(R.id.cvContactUs).setOnClickListener {
            startActivity(Intent(this, ContactUsActivity::class.java))
        }

        findViewById<CardView>(R.id.cvLogout).setOnClickListener {
            val intent = Intent(this, GetStartedActivity::class.java)
            startActivity(intent)
        }
    }
}