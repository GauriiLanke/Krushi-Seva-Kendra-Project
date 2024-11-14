package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductCatalogueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_catalogue)

        findViewById<CardView>(R.id.cvfertilizer).setOnClickListener {
            startActivity(Intent(this, FertilizersActivity::class.java))
        }

        findViewById<CardView>(R.id.cvherbicides).setOnClickListener {
            startActivity(Intent(this, HerbicidesActivity::class.java))
        }

        findViewById<CardView>(R.id.cvfungicides).setOnClickListener {
            startActivity(Intent(this, FungicidesActivity::class.java))
        }

        findViewById<CardView>(R.id.cvpgr).setOnClickListener {
            startActivity(Intent(this, PGRActivity::class.java))
        }

        findViewById<CardView>(R.id.cvmicron).setOnClickListener {
            startActivity(Intent(this, MicroNutrientsActivity::class.java))
        }

        findViewById<CardView>(R.id.cvinsecticides).setOnClickListener {
            startActivity(Intent(this, InsecticidesActivity::class.java))
        }

    }
}