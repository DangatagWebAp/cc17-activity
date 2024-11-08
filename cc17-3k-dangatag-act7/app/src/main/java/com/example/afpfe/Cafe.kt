package com.example.afpfe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Cafe : AppCompatActivity() {

    private lateinit var cityCard: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_cafe)

        cityCard = findViewById(R.id.foam)

        cityCard.setOnClickListener {
            val intent = Intent(this, Foam::class.java)
            startActivity(intent)
        }

    }
}