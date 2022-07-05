package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        Toast.makeText(this, "Roll!",Toast.LENGTH_SHORT).show()

        val randomNum = (1..60).random()
        val numberText: TextView = findViewById(R.id.numberText)
        numberText.text = randomNum.toString()
    }
}