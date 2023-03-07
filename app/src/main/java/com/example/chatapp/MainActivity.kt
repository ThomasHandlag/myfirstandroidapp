package com.example.chatapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            val text: Double? = binding.plainTextInput.text.toString().toDoubleOrNull();
            val currency: Double? = when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButton ->(text?.div(23000.0))
                R.id.radioButton2 ->(text?.div(25000.0))
                R.id.radioButton3 -> (text?.div(40000.0))
                else -> 0.0
            }
            binding.textView.text = currency.toString()
        }

    }

   /* private fun send(): Double {
        val cont: Double = binding.plainTextInput.text.toString().toDoubleOrNull() ?: 0.0
        val opt: Double = when (binding.rdGroup.checkedRadioButtonId) {
            R.id.rd_1 -> 0.5
            R.id.rd_2 -> 0.2
            else -> 0.9
        }
        return opt * cont
    }*/
}
