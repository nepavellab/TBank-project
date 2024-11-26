package com.example.tbankapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbankapplication.databinding.ActivityMainBinding
import com.example.tbankapplication.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit  var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            mainFragment = MainFragment()
            supportFragmentManager
                .beginTransaction()
                .add(binding.main.id,  mainFragment)
                .commit()
        }
    }
}