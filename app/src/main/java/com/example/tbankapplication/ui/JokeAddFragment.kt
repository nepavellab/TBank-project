package com.example.tbankapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbankapplication.data.Joke
import com.example.tbankapplication.databinding.AddJokeBinding
import java.util.UUID

class JokeAddFragment(
    private val viewModel: JokeViewModel
) : Fragment() {
    private var binding: AddJokeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddJokeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) { this!!
            btnAddJoke.setOnClickListener {
                val category = etCategory.text.toString()
                val question = etQuestion.text.toString()
                val answer = etAnswer.text.toString()

                val joke = Joke(UUID.randomUUID(), category, question, answer)
                viewModel.addItem(joke)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}