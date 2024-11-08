package com.example.afpfe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainAct : AppCompatActivity() {

    private lateinit var cityCard: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityCard = findViewById(R.id.cafe)

        cityCard.setOnClickListener {
            val intent = Intent(this, Cafe::class.java)
            startActivity(intent)
        }

        cityCard = findViewById(R.id.Restaurant)

        cityCard.setOnClickListener {
            val intent = Intent(this, Restaurant::class.java)
            startActivity(intent)
        }

        cityCard = findViewById(R.id.parks)

        cityCard.setOnClickListener {
            val intent = Intent(this, Parks::class.java)
            startActivity(intent)
        }



    }
}