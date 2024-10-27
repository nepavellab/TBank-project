package com.example.tbankapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.databinding.JokeBinding

class JokeAdapter() : RecyclerView.Adapter<JokeViewHolder>() {
    private var jokes = Data.jokes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }
}