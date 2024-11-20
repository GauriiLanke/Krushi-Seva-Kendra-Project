package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView

class ProductCatalogueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_catalogue)

        // Set up the toolbar with a back arrow
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle back arrow click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // CardView click listeners
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
