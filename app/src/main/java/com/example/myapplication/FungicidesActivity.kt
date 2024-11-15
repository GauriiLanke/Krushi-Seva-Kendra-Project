package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.cardview.widget.CardView

class FungicidesActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fungicides)
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        // Set up CardViews
        val cvSaaf = findViewById<CardView>(R.id.cvSaaf)
        val cvAntracol = findViewById<CardView>(R.id.cvAntracol)
        val cvMacobanC = findViewById<CardView>(R.id.cvMacobanC)
        val cvCarzeb = findViewById<CardView>(R.id.cvCarzeb)

        // Set click listeners for each CardView
        cvSaaf.setOnClickListener {
            showProductDetails(
                name = "Saaf",
                description = "Suitable for seed treatment",
                imageRes = R.drawable.saaf,
                variants = "Variants: 250GM",
                price = "₹300"
            )
        }

        cvAntracol.setOnClickListener {
            showProductDetails(
                name = "Antracol",
                description = "Protect against target spot and late blight",
                imageRes = R.drawable.antracol,
                variants = "Variants: 500GM",
                price = "₹400"
            )
        }

        cvMacobanC.setOnClickListener {
            showProductDetails(
                name = "Macoban C",
                description = "Used to treat a variety of diseases and crops",
                imageRes = R.drawable.macobanc,
                variants = "Variants: 500GM",
                price = "₹550"
            )
        }

        cvCarzeb.setOnClickListener {
            showProductDetails(
                name = "Carzeb",
                description = "It is used as a foliar spray or for seed treatment",
                imageRes = R.drawable.carzeb,
                variants = "Variants: 250GM",
                price = "₹300"
            )
        }
    }

    private fun showProductDetails(name: String, description: String, imageRes: Int, variants: String, price: String) {
        // Find views in the dialog
        val productImage = productDialog.findViewById<ImageView>(R.id.productImage)
        val productName = productDialog.findViewById<TextView>(R.id.productName)
        val productDescription = productDialog.findViewById<TextView>(R.id.productDescription)
        val productVariants = productDialog.findViewById<TextView>(R.id.productVariants)
        val productPrice = productDialog.findViewById<TextView>(R.id.productPrice)
        val addToCartButton = productDialog.findViewById<Button>(R.id.addToCartButton)

        // Set data to views
        productImage.setImageResource(imageRes)
        productName.text = name
        productDescription.text = description
        productVariants.text = variants
        productPrice.text = price

        // Add to Cart button click listener
        addToCartButton.setOnClickListener {
            // Add the product to cart
            // You can add your cart functionality here
            productDialog.dismiss()
        }

        // Show dialog
        productDialog.show()
    }
}
