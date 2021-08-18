package com.nerostarx.milkystore.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView
import com.nerostarx.milkystore.R
import com.nerostarx.milkystore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MilkyStore)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavView = binding.bottomNavView
        val navController = findNavController(R.id.nav_host_container)

        bottomNavView.setUpWithNavController(navController)

        binding.accountImage.setOnClickListener {
            val intent = Intent(this,AuthActivity::class.java)
            startActivity(intent)
        }

    }

    private fun BubbleNavigationConstraintView.setUpWithNavController(navController: NavController){
        val currentDestination = navController.currentDestination?.id
        val currentPosition = if(currentDestination == R.id.nav_home) {0}
            else {
                if (currentDestination == R.id.nav_cart){1}
                else {2}
            }
        this.setCurrentActiveItem(currentPosition)
        this.setNavigationChangeListener { view, position ->
            this.setCurrentActiveItem(position)
            when(view.id){
                R.id.nav_home -> {
                    navController.navigate(R.id.nav_home)
                }

                R.id.nav_cart -> {
                    navController.navigate(R.id.nav_cart)
                }

                R.id.nav_history -> {
                    navController.navigate(R.id.nav_history)
                }
            }
        }
    }
}