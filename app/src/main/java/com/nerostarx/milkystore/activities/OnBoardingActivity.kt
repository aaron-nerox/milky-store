package com.nerostarx.milkystore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nerostarx.milkystore.R
import com.nerostarx.milkystore.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MilkyStore)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}