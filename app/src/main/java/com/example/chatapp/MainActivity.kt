package com.example.chatapp

import android.icu.text.NumberFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acBtn.setOnClickListener {
            binding.rsView.text =
                getString(R.string.rs_field, NumberFormat.getCurrencyInstance().format(send()))
        }

        binding.sw1.setOnClickListener {
            binding.emailField.visibility =
                if (binding.sw1.isChecked) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun send(): Double {
        val cont: Double = binding.plainTextInput.text.toString().toDoubleOrNull() ?: 0.0
        val opt: Double = when (binding.rdGroup.checkedRadioButtonId) {
            R.id.rd_1 -> 0.5
            R.id.rd_2 -> 0.2
            else -> 0.9
        }
        return opt * cont
    }
}
