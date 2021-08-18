package com.nerostarx.milkystore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.milkystore.databinding.CartItemBinding

class CartAdapter(): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CartItemBinding.inflate(inflater,parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10

    class CartViewHolder(binding: CartItemBinding)
                :RecyclerView.ViewHolder(binding.root) {

    }
}