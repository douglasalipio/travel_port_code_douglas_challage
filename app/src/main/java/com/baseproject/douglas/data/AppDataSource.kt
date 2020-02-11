package com.baseproject.douglas.data

import com.baseproject.douglas.data.feature.city.WeatherDto
import com.baseproject.douglas.data.feature.weather.ForecastDto
import io.reactivex.Flowable


interface AppDataSource {

    fun requestWeatherBy(city: String): Flowable<WeatherDto>

    fun requestForecastBy(city: String): Flowable<ForecastDto>
}