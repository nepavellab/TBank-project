package com.example.tbankapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tbankapplication.data.Data.jokes
import com.example.tbankapplication.databinding.JokeFragmentBinding

class JokeFragment : Fragment() {
    private var binding: JokeFragmentBinding? = null

    companion object {
        private const val KEY = "POSITION"

        fun newInstance(position: Int): JokeFragment {
            return JokeFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY, position)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = JokeFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            val index = getInt(KEY)
            with(binding) { this!!
                tvJokeCategory.text = jokes[index].category
                tvQuestion.text = jokes[index].question
                tvAnswer.text = jokes[index].answer
            }
        }
    }
}