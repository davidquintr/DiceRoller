package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6);
        val randomGen = dice.roll();
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = randomGen.toString();
        changeImg(randomGen)
    }

    private fun changeImg(roll : Int){
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.contentDescription = roll.toString()
        val setImg = when(roll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(setImg)
    }

}

class Dice(val sides : Int){

    fun roll() : Int {
        return (1..sides).random();
    }
}