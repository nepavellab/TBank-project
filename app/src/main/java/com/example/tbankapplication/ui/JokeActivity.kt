package com.example.tbankapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbankapplication.data.Data.jokes
import com.example.tbankapplication.databinding.ActivityJokeBinding

class JokeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJokeBinding
    companion object {
        private const val EXTRA_KEY = "POSITION"
        private const val DEFAULT_EXTRA_VALUE = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getIntExtra(EXTRA_KEY, DEFAULT_EXTRA_VALUE).also { position ->
            with(binding) {
                tvJokeCategory.text = jokes[position].category
                tvQuestion.text = jokes[position].question
                tvAnswer.text = jokes[position].answer
            }
        }
    }
}
