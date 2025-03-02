package com.example.tbankapplication.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.tbankapplication.domain.entity.Joke
import javax.inject.Inject

class JokeDiffUtilCallback @Inject constructor(
    private val oldList: List<Joke>,
    private val newList: List<Joke>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}