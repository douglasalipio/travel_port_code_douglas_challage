package com.baseproject.douglas.util

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

fun RecyclerView.initGridLayout(
    context: Context,
    groupAdapter: GroupAdapter<GroupieViewHolder>
) {

    val gridLayoutManager = LinearLayoutManager(context)
    this.adapter = groupAdapter
    this.layoutManager = gridLayoutManager
}