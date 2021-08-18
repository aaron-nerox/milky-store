package com.nerostarx.milkystore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.milkystore.R
import com.nerostarx.milkystore.databinding.OnboardingItemBinding

class OnBoardingAdapter(): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val animationList = arrayListOf(R.raw.cookies_milk
        ,R.raw.rabbit_with_milk
        ,R.raw.discount)

    private val titleList = arrayListOf("Welcome to milky store"
        , "Top quality milk flavors"
        , "Discounts, a lot of them!")

    private val textList = arrayListOf(
        "Milky store welcomes you to a world full of milk, orange and some of the sweetest things."
        , "Get to enjoy some of the best milk flavors that you will taste in you life, and the best part is that they are home made."
        , "Here at milky store we know that our clients will go all out for us, So we do the same for them, by giving them discounts."
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = OnboardingItemBinding.inflate(layoutInflater,parent,false)
        return OnBoardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.title.text = titleList[position]
        holder.text.text = textList[position]
        holder.animation.setAnimation(animationList[position])
    }

    override fun getItemCount(): Int = 3

    class OnBoardingViewHolder(binding: OnboardingItemBinding)
        :RecyclerView.ViewHolder(binding.root) {

            val animation = binding.animationView
            val title = binding.titleOnboarding
            val text = binding.textOnboarding
    }
}