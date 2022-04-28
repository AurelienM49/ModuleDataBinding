package com.eni.mod10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eni.mod10.databinding.ItemListVoitureBinding

class VoitureAdapter(val listVoiture: ArrayList<Voiture>)
    : RecyclerView.Adapter<VoitureAdapter.VoitureViewHolder>() {
    class VoitureViewHolder(var binding : ItemListVoitureBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoitureViewHolder {
        val binding = ItemListVoitureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VoitureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoitureViewHolder, position: Int) {
        val voiture = listVoiture[position]
        holder.binding.v = voiture
    }

    override fun getItemCount(): Int = listVoiture.size
}