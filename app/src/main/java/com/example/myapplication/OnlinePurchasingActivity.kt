package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

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
            if (CartManager.cartItems.isNotEmpty()) {
                placeOrder()
                CartManager.cartItems.clear()
                adapter.notifyDataSetChanged()
                updateTotalPrice()
                Toast.makeText(this,"Order Placed Successfully", Toast.LENGTH_SHORT).show()
            } else {
                // Notify the user that the cart is empty
                totalPriceTextView.text = "Your cart is empty!"
            }
        }
    }

    private fun updateTotalPrice() {
        totalPriceTextView.text = "Total: ₹${CartManager.calculateTotalPrice()}"
    }

    private fun placeOrder() {
        val database = FirebaseDatabase.getInstance()
        val ordersRef = database.getReference("orders")

        val orderId = ordersRef.push().key ?: run {
            Log.e("FirebaseOrder", "Failed to generate orderId")
            return
        }

        val orderData = mapOf(
            "orderId" to orderId,
            "items" to CartManager.cartItems.map {
                mapOf(
                    "name" to it.name,
                    "quantity" to it.quantity,
                    "price" to it.price
                )
            },
            "totalPrice" to CartManager.calculateTotalPrice(),
            "timestamp" to System.currentTimeMillis()
        )

        Log.d("FirebaseOrder", "Placing order with data: $orderData")

        ordersRef.child(orderId).setValue(orderData).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("FirebaseOrder", "Order placed successfully!")
            } else {
                Log.e("FirebaseOrder", "Order placement failed", task.exception)
            }
        }
    }

}
