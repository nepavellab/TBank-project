package com.example.tbankapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbankapplication.databinding.ActivityMainBinding
import com.example.tbankapplication.ui.recycler.JokeAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokeAdapter
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
        binding.recyclerView.adapter = adapter
    }
}