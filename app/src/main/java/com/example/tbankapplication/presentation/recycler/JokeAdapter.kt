package com.example.tbankapplication.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tbankapplication.domain.entity.Joke
import com.example.tbankapplication.databinding.JokeBinding
import javax.inject.Inject

class JokeAdapter @Inject constructor(
    private val onTapCallback: (Joke) -> Unit,
    private val attachFavourite: (Joke) -> Unit
): RecyclerView.Adapter<JokeViewHolder>() {
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
        holder.bind(jokes[position], onTapCallback, attachFavourite)
    }
}