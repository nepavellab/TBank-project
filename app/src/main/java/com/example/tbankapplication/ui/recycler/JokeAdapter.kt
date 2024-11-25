package com.example.tbankapplication.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.data.Data
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.databinding.JokeBinding

class JokeAdapter(
    private val jokeClickListener: (Int) -> Int
) : RecyclerView.Adapter<JokeViewHolder>() {
    private var jokes = Data.jokes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun setItems(newJokes: List<Joke>) {
        val calculatedDiff = DiffUtil.calculateDiff(
            JokeDiffUtilCallback(jokes, newJokes)
        )
        jokes = newJokes.toMutableList()
        calculatedDiff.dispatchUpdatesTo(this)
    }

    fun addItem(joke: Joke) {
        val calculatedDiff = DiffUtil.calculateDiff(
            JokeDiffUtilCallback(jokes, jokes + joke)
        )
        jokes.add(0, joke)
        calculatedDiff.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position], jokeClickListener, position)
    }
}