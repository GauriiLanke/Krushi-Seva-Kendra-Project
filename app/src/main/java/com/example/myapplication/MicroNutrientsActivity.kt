package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MicroNutrientsActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_micro_nutrients)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        val cvZinc12 = findViewById<CardView>(R.id.cvZinc12)
        val cvChelmix = findViewById<CardView>(R.id.cvChelmix)
        val cvChelatedZinc = findViewById<CardView>(R.id.cvChelatedZinc)
        val cvMagnesiumSulphate = findViewById<CardView>(R.id.cvMagnesiumSulphate)
        val cvKoro=findViewById<CardView>(R.id.cvKoro)

        cvZinc12.setOnClickListener {
            showProductDetails(
                name = "Zinc 12",
                description = "Used to regulate the plant growth",
                imageRes = R.drawable.zinc12,
                variants = "Variants: 100 gm",
                price = "₹550"
            )
        }

        cvChelmix.setOnClickListener {
            showProductDetails(
                name = "Chelmix",
                description = "Used as a foliar spray to promote plant growth and health",
                imageRes = R.drawable.chellmix,
                variants = "Variants: 250 gm",
                price = "₹150"
            )
        }

        cvChelatedZinc.setOnClickListener {
            showProductDetails(
                name = "Chelated Zinc",
                description = "Used in plant fertilizer to improve nutrient absorption and growth",
                imageRes = R.drawable.chelated_zinc,
                variants = "Variants: 100 gm",
                price = "₹120"
            )
        }

        cvMagnesiumSulphate.setOnClickListener {
            showProductDetails(
                name = "Magnesium Sulphate",
                description = "To correct magnesium deficiency in the soil",
                imageRes = R.drawable.magnesiums,
                variants = "",
                price = "₹350"
            )
        }

        cvKoro.setOnClickListener {
            showProductDetails(
                name = "Koro",
                description = "Used as essential micronutrient for plants",
                imageRes = R.drawable.koro,
                variants = "Variants: 100 ml",
                price = "₹70"
            )
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
            val productPriceValue = price.replace("₹", "").toDouble()
            CartManager.addToCart(name, productPriceValue)
            productDialog.dismiss()
            Toast.makeText(this,"Product added to cart", Toast.LENGTH_SHORT).show()
        }

        productDialog.show()
    }
}