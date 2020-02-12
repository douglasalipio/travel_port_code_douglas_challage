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
    val date: String,
    @SerializedName("sys")
    val countryInfo: Sys
)


data class Main(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float,
    @SerializedName("humidity")
    val humidity: Int
)

data class Sys(
    @SerializedName("country")
    val country: String
)