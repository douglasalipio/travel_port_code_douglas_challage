package com.baseproject.douglas.data.feature.weather

import com.baseproject.douglas.data.feature.forecast.ForecastDto
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("name")
    val name: String,
    val forecastDtoDetail: List<ForecastDto>,
    @SerializedName("main")
    val main: Main,
    @SerializedName("dt")
    val date :  String
)


data class Main(
    @SerializedName("temp")
    var temp: Float,
    @SerializedName("feels_like")
    var feelsLike: Float,
    @SerializedName("humidity")
    var humidity: Int
)