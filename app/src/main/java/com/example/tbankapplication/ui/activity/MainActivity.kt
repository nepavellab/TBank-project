package com.example.tbankapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tbankapplication.databinding.ActivityMainBinding
import com.example.tbankapplication.viewmodel.JokeViewModel
import com.example.tbankapplication.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: JokeViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit  var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[JokeViewModel::class.java]

        if (savedInstanceState == null) {
            mainFragment = MainFragment(viewModel)
            supportFragmentManager
                .beginTransaction()
                .add(binding.main.id,  mainFragment)
                .commit()
            viewModel.loadJokes()
        }
    }
}