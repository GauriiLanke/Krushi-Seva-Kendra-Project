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

class PGRActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pgractivity)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        val cvHoomr = findViewById<CardView>(R.id.cvHoomR)
        val cvHydrolic = findViewById<CardView>(R.id.cvHydrolic)
        val cvPrimeGold = findViewById<CardView>(R.id.cvPrimeGold)
        val cvEazyStim = findViewById<CardView>(R.id.cvEazyStim)
        val cvGrower=findViewById<CardView>(R.id.cvGrower)
        val cvAgroHumicid=findViewById<CardView>(R.id.cvAgroHumicid)
        val cvAspa81=findViewById<CardView>(R.id.cvAspa81)
        val cvMacifert=findViewById<CardView>(R.id.cvMacifert)

        cvHoomr.setOnClickListener {
            showProductDetails(
                name = "Hoom-R",
                description = "Used to increase soil fertility and promote healthy plant growth",
                imageRes = R.drawable.hoomr,
                variants = "Variants: 250 gm",
                price = "₹380"
            )
        }

        cvHydrolic.setOnClickListener {
            showProductDetails(
                name = "Hydrolic",
                description = "To improve a plant's ability to tolerate abiotic stress",
                imageRes = R.drawable.hydrolic,
                variants = "Variants: 1 l",
                price = "₹650"
            )
        }

        cvPrimeGold.setOnClickListener {
            showProductDetails(
                name = "Prime Gold",
                description = "To promote plant growth,improve flowering, and enhance fruit development",
                imageRes = R.drawable.primegold,
                variants = "1 l",
                price = "₹850"
            )
        }

        cvEazyStim.setOnClickListener {
            showProductDetails(
                name = "Eazy Stim",
                description = "Used to stimulate the plant growth",
                imageRes = R.drawable.eazystimm,
                variants = "Variants: 250 ml",
                price = "₹670"
            )
        }

        cvGrower.setOnClickListener {
            showProductDetails(
                name = "Grower",
                description = "To suppress or promote growth,increase branching, or delay flowering",
                imageRes = R.drawable.grower_pgr,
                variants = "Variants: 500 ml",
                price = "₹400"
            )
        }

        cvAgroHumicid.setOnClickListener {
            showProductDetails(
                name = "Agro Humicid",
                description = "Facilitate rapid and uniform seed germination",
                imageRes = R.drawable.agrohumacid,
                variants = "Variants: 1 l",
                price = "₹550"
            )
        }

        cvAspa81.setOnClickListener {
            showProductDetails(
                name = "Aspa 81",
                description = "Used to regulate plant growth,harvest periods and thin fruit",
                imageRes = R.drawable.aspa_81,
                variants = "Variants: 100 ml",
                price = "₹150"
            )
        }

        cvMacifert.setOnClickListener {
            showProductDetails(
                name = "Macifert",
                description = "To control weeds in wheat,potato,soyabean,tomato and sugarcane",
                imageRes = R.drawable.macifert,
                variants = "Variants: 500 ml",
                price = "₹250"
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