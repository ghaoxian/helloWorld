package com.example.helloworld

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var diceImg : ImageView
    lateinit var numberText : TextView
    lateinit var nameText : TextView
    lateinit var playerNameText : TextView
    private val playerName: GameInfo = GameInfo(playerName = "Ready Player One?")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.gameInfo = playerName
        //diceImg = findViewById(R.id.dice_image)
        //numberText = findViewById(R.id.numberText)
        //nameText = findViewById(R.id.editPlayerName)
        //playerNameText = findViewById(R.id.playerName)
        //val rollButton: Button = findViewById(R.id.rollButton)
        //rollButton.setOnClickListener{rollDice()}
        //val subBtn: Button = findViewById(R.id.subBtn)
        //subBtn.setOnClickListener { submitName(it) }

        binding.rollButton.setOnClickListener{rollDice()}
        binding.subBtn.setOnClickListener{submitName(it)}

    }
    private fun submitName(view: View) {
        //playerNameText.text = nameText.text
        binding.apply{
            binding.playerName.text = binding.editPlayerName.text
            binding.playerName.clearComposingText()
        }
        //binding.playerName.text = binding.editPlayerName.text
        //binding.editPlayerName.text.clear()
        //val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        //imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    private fun rollDice(){
        Toast.makeText(this, "Roll!",Toast.LENGTH_SHORT).show()

        val randomNum = (1..6).random()
        //numberText.text = randomNum.toString()
        val imgSrc = when(randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(imgSrc)
        binding.numberText.text = randomNum.toString()
        //diceImg.setImageResource(imgSrc)
    }
}