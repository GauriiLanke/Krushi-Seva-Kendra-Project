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

class InsecticidesActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecticides)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        val cvPolytrinC = findViewById<CardView>(R.id.cvPolytrinC)
        val cvCannon = findViewById<CardView>(R.id.cvCannon)
        val cvProfexSuper= findViewById<CardView>(R.id.cvProfexS)
        val cvCombiXSuper = findViewById<CardView>(R.id.cvCombiXSuper)
        val cvJump=findViewById<CardView>(R.id.cvJump)
        val cvProclaim=findViewById<CardView>(R.id.cvProclaim)
        val cvUlala=findViewById<CardView>(R.id.cvUlala)

        cvPolytrinC.setOnClickListener {
            showProductDetails(
                name = "Polytrin C",
                description = "Used to control variety of pests in vegetable and cotton crops",
                imageRes = R.drawable.polytrinc,
                variants = "Variants: 500 ml",
                price = "₹550"
            )
        }

        cvCannon.setOnClickListener {
            showProductDetails(
                name = "Cannon",
                description = "Used to control caterpillars and sucking pests",
                imageRes = R.drawable.cannon,
                variants = "Variants: 250 ml",
                price = "₹300"
            )
        }

        cvProfexSuper.setOnClickListener {
            showProductDetails(
                name = "Profex Super",
                description = "Used in variety of settings to control insect pests",
                imageRes = R.drawable.profex_super,
                variants = "250 ml",
                price = "₹330"
            )
        }

        cvCombiXSuper.setOnClickListener {
            showProductDetails(
                name = "Combi-X Super",
                description = "Used to cure pink boll,spotted boll worms,aphids and white fly",
                imageRes = R.drawable.combix_super,
                variants = "Variants: 250 ml",
                price = "₹300"
            )
        }

        cvJump.setOnClickListener {
            showProductDetails(
                name = "Jump",
                description = "To protect crops from a wide range of pests like caterpillars,beetles,spider mites,etc",
                imageRes = R.drawable.jumpp,
                variants = "Variants: 7 gm",
                price = "₹70"
            )
        }

        cvProclaim.setOnClickListener {
            showProductDetails(
                name = "Proclaim",
                description = "Delivers excellent control of damaging pests like armyworms,pinworms,fruitworms and leafrollers",
                imageRes = R.drawable.proclaim,
                variants = "",
                price = "₹350"
            )
        }

        cvUlala.setOnClickListener {
            showProductDetails(
                name = "Ulala",
                description = "Used to control sucking pests on crops like cotton and paddy",
                imageRes = R.drawable.ulala,
                variants = "Variants: 60 gm",
                price = "₹600"
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