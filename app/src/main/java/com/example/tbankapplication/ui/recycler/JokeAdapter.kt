package com.example.tbankapplication.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.Loader
import com.example.tbankapplication.database.Joke
import com.example.tbankapplication.databinding.JokeBinding

class JokeAdapter(
    private val loader: Loader
) : RecyclerView.Adapter<JokeViewHolder>() {
    private var jokes = mutableListOf<Joke>()

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

    override fun getItemCount() = jokes.size

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val openJokeCallback = { joke: Joke ->
            loader.onTapCallback(joke)
        }
        holder.bind(jokes[position], openJokeCallback)
    }
}