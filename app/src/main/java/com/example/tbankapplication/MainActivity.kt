package com.example.tbankapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbankapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = JokeAdapter()
        binding.recyclerView.adapter = adapter
    }
} 