package com.baseproject.douglas.data

import com.baseproject.douglas.data.feature.weather.WeatherDto
import com.baseproject.douglas.data.feature.forecast.ForecastDto

interface AppDataSource {

    suspend fun requestWeatherBy(city: String): WeatherDto

    suspend fun requestForecastBy(city: String): ForecastDto
}