package com.example.tbankapplication.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.databinding.JokeBinding

class JokeAdapter(
    private val jokeClickListener: (Int) -> Unit
) : RecyclerView.Adapter<JokeViewHolder>() {
    private val jokes = Data.jokes.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun addItem(joke: Joke) {
        val calculatedDiff = DiffUtil.calculateDiff(
            JokeDiffUtilCallback(jokes, jokes + joke)
        )
        jokes.add(joke)
        calculatedDiff.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position], jokeClickListener, position)
    }
}