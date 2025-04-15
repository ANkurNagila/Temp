package com.gfg.ricky_morty_recycler_fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gfg.ricky_morty_recycler_fragments.Data.Data
import com.gfg.ricky_morty_recycler_fragments.databinding.DataRowBinding

class SimpleAdapter(
    private val OnClickCallback:()->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val data = ArrayList<Data.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharacterViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CharacterViewHolder).onBind(data[position],OnClickCallback)
    }

    fun setData(characterData: List<Data.Result>) {
        this.data.clear()
        this.data.addAll(characterData)
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        DataRowBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
    ) {
        // Create binding instance
        private val binding = DataRowBinding.bind(itemView)

        fun onBind(character: Data.Result,onClicked:()->Unit) {
            // Load image with Glide
            Glide.with(itemView.context)
                .load(character.image)
                .into(binding.image)

            // Set text for character details
            binding.name.text = character.name
            binding.status.text = character.status
            binding.gender.text = character.gender

        }
    }
}