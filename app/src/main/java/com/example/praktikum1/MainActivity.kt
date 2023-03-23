package com.example.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button3)
        rollButton.setOnClickListener { rollDice() }
        //Menampilkan dadu saat aplikasi dibuka
        rollDice()
    }

    private fun rollDice() {
        //Membuat objek dadu dengan 6 sisi dan acak dadu
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Menentukan ImageView pada layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Menentukan sumber id pada gambar sesuai dengan dadu yang diacak
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
        }
    }
}