package com.baseproject.douglas.feature.weather.data

class WeatherInfo(
    val city: String,
    val country : String,
    val humidity: String,
    val tempeture: String,
    val feelsLike: String,
    var forecastList: MutableList<ForecastInfo> = mutableListOf()
)