package com.baseproject.douglas.feature.weather.data

class WeatherInfo(
    val city: String,
    val humidity: String,
    val tempeture: String,
    val feelsLike: String,
    val forecastList: MutableList<ForecastInfo> = mutableListOf()
)