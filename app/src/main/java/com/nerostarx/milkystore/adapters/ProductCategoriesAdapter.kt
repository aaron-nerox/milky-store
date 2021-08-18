package com.nerostarx.milkystore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.milkystore.databinding.CategoryItemBinding

class ProductCategoriesAdapter()
    :RecyclerView.Adapter<ProductCategoriesAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(layoutInflater, parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 25

    class CategoryViewHolder(binding: CategoryItemBinding)
        :RecyclerView.ViewHolder(binding.root) {

    }
}