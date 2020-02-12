package com.baseproject.douglas.data.feature.forecast

import com.google.gson.annotations.SerializedName


data class ForecastDto(
    @SerializedName("list")
    val list: kotlin.collections.List<List>
)

data class List(
    @SerializedName("dt")
    val timestamp: Long,
    @SerializedName("dt_txt")
    val dateUtcString: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("weather")
    val weather: kotlin.collections.List<Weather>
)

data class Main(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float
)

data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)