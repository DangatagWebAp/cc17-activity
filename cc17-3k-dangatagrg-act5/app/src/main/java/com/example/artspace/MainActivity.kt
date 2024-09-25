package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.photo11)
        val nextButton = findViewById<Button>(R.id.next)
        val prevButton = findViewById<Button>(R.id.prev)
        val images = intArrayOf(R.drawable.photo1, R.drawable.photo3, R.drawable.photo4, R.drawable.photo4, R.drawable.photo5)
        val textOverlay = findViewById<TextView>(R.id.textOver)
        var currentImageIndex = 0

        nextButton.setOnClickListener {
            currentImageIndex = (currentImageIndex + 1) % images.size
            imageView.setImageResource(images[currentImageIndex])
            textOverlay.visibility = View.VISIBLE


        prevButton.setOnClickListener { // Add OnClickListener for Previous button
            currentImageIndex = (currentImageIndex - 1 + images.size) % images.size // Decrement and wrap around
            imageView.setImageResource(images[currentImageIndex])
            textOverlay.visibility = View.VISIBLE
        }


    }
}

private fun ImageView.setImageResource(image: IntArray) {

}
