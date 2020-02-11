package com.baseproject.douglas.data.feature.forecast

import com.google.gson.annotations.SerializedName


data class ForecastDto(
    @SerializedName("list")
    val list: kotlin.collections.List<List>
)

data class List(
    @SerializedName("dt")
    var dt: Int,
    @SerializedName("main")
    var main: Main,
    @SerializedName("weather")
    var weather: kotlin.collections.List<Weather>
)

data class Main(
    @SerializedName("temp")
    var temp: Float,
    @SerializedName("feels_like")
    var feelsLike: Float,
    @SerializedName("humidity")
    var humidity: Int
)

data class Weather(
    @SerializedName("description")
    var description: String,
    @SerializedName("icon")
    var icon: String
)