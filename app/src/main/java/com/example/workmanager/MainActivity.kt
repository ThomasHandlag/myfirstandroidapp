package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
//https://forms.gle/nSx9czXPB6FcWNseA