package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImg : ImageView
    lateinit var numberText : TextView
    lateinit var nameText : TextView
    lateinit var playerrNameText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.dice_image)
        numberText = findViewById(R.id.numberText)
        nameText = findViewById(R.id.editPlayerName)
        playerrNameText = findViewById(R.id.playerName)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{rollDice()}
        val subBtn: Button = findViewById(R.id.subBtn)
        subBtn.setOnClickListener { submitName(it) }
    }
    private fun submitName(view: View){
        playerrNameText.text = nameText.text
    }


    private fun rollDice(){
        Toast.makeText(this, "Roll!",Toast.LENGTH_SHORT).show()

        val randomNum = (1..6).random()
        //val numberText: TextView = findViewById(R.id.numberText)
        numberText.text = randomNum.toString()
        //val diceImg : ImageView = findViewById(R.id.dice_image)
        val imgSrc = when(randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(imgSrc)
    }
}