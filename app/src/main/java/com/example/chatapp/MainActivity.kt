package com.example.chatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val diceRoll = Dice(10)
        button.setOnClickListener {
            val textView: TextView = findViewById(R.id.textView)
            textView.text = diceRoll.plus().toString()
            val imageView: ImageView = findViewById(R.id.imageView)
            imageView.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }
}

class Dice(private val num: Int, var inc: Int = 0) {
    fun rollDice(): Int {
        return (1..num).random()
    }

    fun plus(): Int {
        return inc++
    }
}