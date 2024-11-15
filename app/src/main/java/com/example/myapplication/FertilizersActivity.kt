package com.example.myapplication

import android.os.Bundle
import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.myapplication.data.Product

class FertilizersActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fertilizers)
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        // Set up CardViews for 15 products
        setupCardViewListeners()
    }

    private fun setupCardViewListeners() {
        val products = listOf(
            Product(
                name = "Product 1",
                description = "Description for Product 1",
                imageRes = R.drawable.urea,
                variants = "Variants: 1KG - ₹500",
                price = "₹500"
            ),
            Product(
                name = "Product 2",
                description = "Description for Product 2",
                imageRes = R.drawable.magnesiums_fertilizer,
                variants = "Variants: 500GM - ₹300",
                price = "₹300"
            ),
            // Add the remaining products up to Product 15
        )

        products.forEachIndexed { index, product ->
            val productCardView = findViewById<CardView>(resources.getIdentifier("cvProduct${index + 1}", "id", packageName))
            productCardView?.setOnClickListener {
                showProductDetails(
                    name = product.name,
                    description = product.description,
                    imageRes = product.imageRes,
                    variants = product.variants,
                    price = product.price
                )
            }
        }
    }

    private fun showProductDetails(name: String, description: String, imageRes: Int, variants: String, price: String) {
        val productImage = productDialog.findViewById<ImageView>(R.id.productImage)
        val productName = productDialog.findViewById<TextView>(R.id.productName)
        val productDescription = productDialog.findViewById<TextView>(R.id.productDescription)
        val productVariants = productDialog.findViewById<TextView>(R.id.productVariants)
        val productPrice = productDialog.findViewById<TextView>(R.id.productPrice)
        val addToCartButton = productDialog.findViewById<Button>(R.id.addToCartButton)

        productImage.setImageResource(imageRes)
        productName.text = name
        productDescription.text = description
        productVariants.text = variants
        productPrice.text = price

        addToCartButton.setOnClickListener {
            productDialog.dismiss()
        }

        productDialog.show()
    }
}
