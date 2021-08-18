package com.nerostarx.milkystore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.milkystore.databinding.TopPicksItemBinding

class TopPicksAdapter():RecyclerView.Adapter<TopPicksAdapter.TopPicksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPicksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =  TopPicksItemBinding.inflate(inflater,parent,false)
        return TopPicksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopPicksViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 5

    class TopPicksViewHolder(binding:  TopPicksItemBinding)
        :RecyclerView.ViewHolder(binding.root) {

    }
}