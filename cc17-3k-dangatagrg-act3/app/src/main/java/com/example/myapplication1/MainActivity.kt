package com.example.myapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rollButtonMA : Button= findViewById(R.id.button_MA)
        rollButtonMA.setOnClickListener {
            
            rollDiceMA()
            //val textViewMA: TextView = findViewById(R.id.textView)

            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_LONG)
            toast.show()
        }

    }

    private fun rollDiceMA() {
        val diceMA = DiceMA(6)
        val cuberoll = diceMA.rollMA()
        val imagedice: ImageView = findViewById(R.id.imageView)
        imagedice.setImageResource(R.drawable.dice__5)

        if (cuberoll==1){
            imagedice.setImageResource(R.drawable.dice)
        } else if(cuberoll==2){
            imagedice.setImageResource(R.drawable.dice_result_two)
        } else if(cuberoll==3){
            imagedice.setImageResource(R.drawable.dice_roll_3)
        } else if(cuberoll==4){
            imagedice.setImageResource(R.drawable.die_face_4)
        } else if(cuberoll==6){
            imagedice.setImageResource(R.drawable.die_face_6)
        }
    }

    class DiceMA (val numSidesMA: Int) {
        fun rollMA(): Int {
            return (1..numSidesMA).random()
        }
    }
}