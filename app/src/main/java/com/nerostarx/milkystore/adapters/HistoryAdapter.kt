package com.nerostarx.milkystore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nerostarx.milkystore.databinding.HistoryItemBinding

class HistoryAdapter():RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoryItemBinding.inflate(inflater,parent,false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10

    class HistoryViewHolder(binding: HistoryItemBinding)
                :RecyclerView.ViewHolder(binding.root) {

    }
}