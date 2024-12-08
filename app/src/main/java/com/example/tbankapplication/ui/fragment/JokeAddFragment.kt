package com.example.tbankapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbankapplication.Loader
import com.example.tbankapplication.database.Joke
import com.example.tbankapplication.database.LoadType
import com.example.tbankapplication.databinding.AddJokeBinding
import kotlin.random.Random

class JokeAddFragment(
    private val loader: Loader
) : Fragment() {
    private lateinit var binding: AddJokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddJokeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnAdd.setOnClickListener {
                val category = etCategory.text.toString()
                val question = etQuestion.text.toString()
                val answer = etAnswer.text.toString()
                val joke = Joke(
                    id = Random.nextInt(Int.MAX_VALUE),
                    category = category,
                    question = question,
                    answer = answer,
                    loadType = LoadType.USER
                )
                loader.addJokeCallback(joke)
                parentFragmentManager.popBackStack()
            }
        }
    }
}