package com.example.geneLabs.ui

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class RecyclerItemClickListener(
    context: Context, recyclerView: androidx.recyclerview.widget.RecyclerView,
    listener: OnRecyclerClickListener
) : androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener() {

    interface OnRecyclerClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    private val gestureDetector =
        GestureDetectorCompat(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                childView ?: return false
                listener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView))
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                childView ?: return
                listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
            }
        })

    override fun onInterceptTouchEvent(
        rv: androidx.recyclerview.widget.RecyclerView,
        e: MotionEvent
    ): Boolean {
        val result = gestureDetector.onTouchEvent(e)
        return result
    }
}