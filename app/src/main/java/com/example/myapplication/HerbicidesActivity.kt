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

class HerbicidesActivity : AppCompatActivity() {
    private lateinit var productDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_herbicides)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        productDialog = Dialog(this)
        productDialog.setContentView(R.layout.activity_dialog_product_details)

        val cvGrammaxone = findViewById<CardView>(R.id.cvGrammaxone)
        val cvTorry = findViewById<CardView>(R.id.cvTorry)
        val cvWeedmarSuper = findViewById<CardView>(R.id.cvWeedmarSuper)
        val cvGaligan = findViewById<CardView>(R.id.cvGaligan)
        val cvAgil=findViewById<CardView>(R.id.cvAgil)
        val cvEvenSo=findViewById<CardView>(R.id.cvEvenso)
        val cvFusilade=findViewById<CardView>(R.id.cvFusilade)
        val cvSencor=findViewById<CardView>(R.id.cvSensor)
        val cvTargaSuper=findViewById<CardView>(R.id.cvTargaSuper)

        cvGrammaxone.setOnClickListener {
            showProductDetails(
                name = "Grammaxone",
                description = "Used to control most fibrous rooted grasses and annual broadleaf weeds",
                imageRes = R.drawable.grammaxone,
                variants = "",
                price = "₹520"
            )
        }

        cvTorry.setOnClickListener {
            showProductDetails(
                name = "Torry+Strike",
                description = "Used to control weeds in maize crops",
                imageRes = R.drawable.torry,
                variants = "",
                price = "₹1650"
            )
        }

        cvWeedmarSuper.setOnClickListener {
            showProductDetails(
                name = "Weedmar Super",
                description = "Used to control broadleaf weeds and cyperus sp",
                imageRes = R.drawable.weedmar_super,
                variants = "",
                price = "₹550"
            )
        }

        cvGaligan.setOnClickListener {
            showProductDetails(
                name = "Galigan",
                description = "Controls a wide spectrum of annual broadleaf and grass weeds",
                imageRes = R.drawable.galigan,
                variants = "Variants: 100 ml",
                price = "₹450"
            )
        }

        cvAgil.setOnClickListener {
            showProductDetails(
                name = "Agil",
                description = "To control annual and perennial grasses in a variety of crops",
                imageRes = R.drawable.agil,
                variants = "Variants: 100 ml",
                price = "₹450"
            )
        }

        cvEvenSo.setOnClickListener {
            showProductDetails(
                name = "EvenSo",
                description = "Used to target and eliminate unwanted weeds",
                imageRes = R.drawable.evenso,
                variants = "Variants: 250 ml",
                price = "₹850"
            )
        }

        cvFusilade.setOnClickListener {
            showProductDetails(
                name = "Fusilade",
                description = "Used to control grass weeds around dicot plants",
                imageRes = R.drawable.fusilade,
                variants = "Variants: 250 ml",
                price = "₹850"
            )
        }

        cvSencor.setOnClickListener {
            showProductDetails(
                name = "Sencor",
                description = "To control weeds in wheat,potato,soyabean,tomato and sugarcane",
                imageRes = R.drawable.sencor,
                variants = "",
                price = "₹1700"
            )
        }

        cvTargaSuper.setOnClickListener {
            showProductDetails(
                name = "Targa Super",
                description = "Used to control narrow-leaf weeds in broad-leaf crops",
                imageRes = R.drawable.targasuper,
                variants = "",
                price = "₹450"
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