package com.baseproject.douglas.feature.weather.view

import android.annotation.SuppressLint
import com.baseproject.douglas.R
import com.baseproject.douglas.feature.weather.data.ForecastInfo

import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.product_item.view.*

@SuppressLint("SetTextI18n")
class WeatherItem(
    private val forecastInfo: ForecastInfo
) : Item() {


    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Glide.with(context).load(forecastInfo.iconUrl).into(weatherIcon)
            dateLabel.text = forecastInfo.date
            descriptionLabel.text = forecastInfo.description
            degreeLabel.text = "${forecastInfo.temperature}°"
            realFeelingLabel.text = "${forecastInfo.feelsLike}°"
        }
    }

    override fun getLayout() = R.layout.product_item
}