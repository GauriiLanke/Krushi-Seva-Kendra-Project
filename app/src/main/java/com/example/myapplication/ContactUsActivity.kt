package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Handle social media and email actions
        findViewById<ImageView>(R.id.iv2).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:shrikrushnafertilizers3607@gmail.com"))
            startActivity(Intent.createChooser(emailIntent, "Send email"))
        }

        findViewById<ImageView>(R.id.iv3).setOnClickListener {
            val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/shrikrushna_fertilizers"))
            startActivity(instagramIntent)
        }

        findViewById<ImageView>(R.id.iv4).setOnClickListener {
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/@shrikrushnafertilizers"))
            startActivity(youtubeIntent)
        }

        findViewById<ImageView>(R.id.iv5).setOnClickListener {
            val facebookIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=61568493254955&mibextid=ZbWKwL"))
            startActivity(facebookIntent)
        }
    }
}
