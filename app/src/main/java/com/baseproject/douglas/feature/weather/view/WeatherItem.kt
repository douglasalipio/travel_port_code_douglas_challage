package com.baseproject.douglas.feature.weather.view

import com.baseproject.douglas.R
import com.baseproject.douglas.feature.weather.data.ForecastInfo

import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.product_item.view.*


class WeatherItem(
    private val forecastInfo: ForecastInfo
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Glide.with(context).load(forecastInfo.iconUrl).into(weatherIcon)
            date.text = forecastInfo.date
            description.text = forecastInfo.description
            degreeLabel.text = forecastInfo.temperature
            realFeelingLabel.text = forecastInfo.feelsLike
        }
    }

    override fun getLayout() = R.layout.product_item
}