package com.example.tbankapplication.presentation.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class ScrollListener @Inject constructor(
    private val onLoadCallback: () -> Unit
) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!recyclerView.canScrollVertically(View.FOCUS_DOWN)) {
            onLoadCallback()
        }
    }
}