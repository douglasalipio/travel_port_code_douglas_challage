package com.baseproject.douglas.feature.weather.view

import com.baseproject.douglas.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.weather_header.view.*

class WeatherHeader(private val title: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.headerTitle.text = title
    }

    override fun getLayout() = R.layout.weather_header
}
