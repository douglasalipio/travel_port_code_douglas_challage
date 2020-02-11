package com.baseproject.douglas.feature.weather.data

class WeatherInfo(
    private val city: String,
    private val forecastList: MutableList<ForecastInfo>
)