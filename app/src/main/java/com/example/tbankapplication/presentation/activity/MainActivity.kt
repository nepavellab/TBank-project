package com.example.tbankapplication.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.tbankapplication.databinding.ActivityMainBinding
import com.example.tbankapplication.presentation.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit  var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            mainFragment = MainFragment()
            supportFragmentManager.commit {
                add(binding.main.id,  mainFragment)
            }
        }
    }
}