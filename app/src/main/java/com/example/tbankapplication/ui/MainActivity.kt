package com.example.tbankapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tbankapplication.databinding.ActivityMainBinding
import com.example.tbankapplication.ui.recycler.JokeAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokeAdapter
    private val viewModel: JokeViewModel by lazy {
        ViewModelProvider(this, JokeViewModelFactory())[JokeViewModel::class.java]
    }
    companion object {
        private const val EXTRA_KEY = "POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = JokeAdapter { position ->
            this.startActivity(Intent(this, JokeActivity::class.java).apply {
                putExtra(EXTRA_KEY, position)
            })
        }

        viewModel.jokeList.observe(this, Observer { newJokes ->
            adapter.setItems(newJokes)
        })

        binding.recyclerView.adapter = adapter
    }
}