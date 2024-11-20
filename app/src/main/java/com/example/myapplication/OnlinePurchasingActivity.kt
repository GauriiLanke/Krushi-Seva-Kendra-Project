package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class OnlinePurchasingActivity : AppCompatActivity() {

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var totalPriceTextView: TextView
    private lateinit var placeOrderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_purchasing)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        cartRecyclerView = findViewById(R.id.cartRecyclerView)
        totalPriceTextView = findViewById(R.id.totalPriceTextView)
        placeOrderButton = findViewById(R.id.placeOrderButton)

        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CartAdapter(CartManager.cartItems) {
            updateTotalPrice()
        }
        cartRecyclerView.adapter = adapter

        updateTotalPrice()

        placeOrderButton.setOnClickListener {
            CartManager.cartItems.clear()
            adapter.notifyDataSetChanged()
            updateTotalPrice()
        }
    }

    private fun updateTotalPrice() {
        totalPriceTextView.text = "Total: ₹${CartManager.calculateTotalPrice()}"
    }
}
