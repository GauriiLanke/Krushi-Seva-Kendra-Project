package com.example.myapplication

import android.os.Bundle
import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.myapplication.data.Product

class FertilizersActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fertilizers)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        val cvUrea = findViewById<CardView>(R.id.cvUrea)
        val cvFertilizer151515 = findViewById<CardView>(R.id.cvFertilizer151515)
        val cvFertilizer2020013 = findViewById<CardView>(R.id.cvFertilizer2020013)
        val cvMicroferty = findViewById<CardView>(R.id.cvMicroferty)
        val cvPotash=findViewById<CardView>(R.id.cvPotash)
        val cvCityCompost=findViewById<CardView>(R.id.cvCityCompost)
        val cvDAP=findViewById<CardView>(R.id.cvDAP)
        val cvFertilizer24240=findViewById<CardView>(R.id.cvFertilizer24240)
        val cvMagnesiumS=findViewById<CardView>(R.id.cvMagnesiumSulphate)
        val cvNanoUrea=findViewById<CardView>(R.id.cvNanoUrea)

        cvUrea.setOnClickListener {
            showProductDetails(
                name = "Urea",
                description = "Used to promote plant growth and crop yields",
                imageRes = R.drawable.urea,
                variants = "",
                price = "₹300"
            )
        }

        cvFertilizer151515.setOnClickListener {
            showProductDetails(
                name = "15×15×15 Fertilizer",
                description = "Used for vegetable crops like tomato,pepper,cucumber,watermelon,okra and egg plants",
                imageRes = R.drawable.fertilizer_15_15_15,
                variants = "",
                price = "₹1500"
            )
        }

        cvFertilizer2020013.setOnClickListener {
            showProductDetails(
                name = "20×20×0×13 Fertilizer",
                description = "Used to supply plants with nitrogen,phosphorus and sulfur",
                imageRes = R.drawable.fertilizer_20_20_0_13,
                variants = "",
                price = "₹1400"
            )
        }

        cvMicroferty.setOnClickListener {
            showProductDetails(
                name = "Microferty",
                description = "Used to supplement soil with nutrients",
                imageRes = R.drawable.microferty,
                variants = "",
                price = "₹750"
            )
        }

        cvPotash.setOnClickListener {
            showProductDetails(
                name = "Potash",
                description = "Used to support plant growth and improve disease resistance",
                imageRes = R.drawable.potash,
                variants = "",
                price = "₹850"
            )
        }

        cvCityCompost.setOnClickListener {
            showProductDetails(
                name = "City Compost",
                description = "To improve soil health and increase crop yields",
                imageRes = R.drawable.city_compost,
                variants = "",
                price = "₹300"
            )
        }

        cvDAP.setOnClickListener {
            showProductDetails(
                name = "DAP",
                description = "Used to provide plants with phosphorus and nitrogen",
                imageRes = R.drawable.dap_fertilizer,
                variants = "",
                price = "₹1400"
            )
        }

        cvFertilizer24240.setOnClickListener {
            showProductDetails(
                name = "24×24×0 Fertilizer",
                description = "To supply nitrogen,phosphorus and sulfur to crops",
                imageRes = R.drawable.fertilizer_24_24_0,
                variants = "",
                price = "₹200"
            )
        }

        cvMagnesiumS.setOnClickListener {
            showProductDetails(
                name = "Magnesium Sulphate",
                description = "Used to correct magnesium deficiency in the soil",
                imageRes = R.drawable.magnesiums_fertilizer,
                variants = "",
                price = "₹750"
            )
        }

        cvNanoUrea.setOnClickListener {
            showProductDetails(
                name = "Nano Urea",
                description = "Provides nitrogen to crops",
                imageRes = R.drawable.nano_ureaa,
                variants = "Variants: 500 ml",
                price = "₹225"
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
