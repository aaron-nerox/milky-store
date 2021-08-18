package com.nerostarx.milkystore.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import com.nerostarx.milkystore.R
import com.nerostarx.milkystore.adapters.OnBoardingAdapter
import com.nerostarx.milkystore.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MilkyStore)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("MILKY_STORE",MODE_PRIVATE)
        if (!preferences.getBoolean("IS_FIRST_LAUNCH",true)){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent).also { finish() }
        }

        initSlider()
        binding.skipButton.setOnClickListener {
            preferences.edit {
                putBoolean("IS_FIRST_LAUNCH", false)
            }
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent).also { finish() }
        }
    }

    private fun initSlider() {
        val onBoardingPager = binding.onboardingPager
        onBoardingPager.adapter = OnBoardingAdapter()
        onBoardingPager.orientation = ORIENTATION_HORIZONTAL

        var currentPosition = onBoardingPager.currentItem

        binding.nextButton.setOnClickListener {
            if(currentPosition+1 <= 2){
                currentPosition +=1
                onBoardingPager.currentItem = currentPosition
            }else{
                preferences.edit {
                    putBoolean("IS_FIRST_LAUNCH", false)
                }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent).also { finish() }
            }
        }

        binding.backButton.setOnClickListener {
            if(currentPosition-1 >= 0){
                currentPosition -=1
                onBoardingPager.currentItem = currentPosition
            }else{
                finish()
            }
        }
    }
}