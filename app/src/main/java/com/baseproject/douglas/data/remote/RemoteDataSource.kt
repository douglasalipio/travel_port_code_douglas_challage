package com.baseproject.douglas.data.remote

import com.baseproject.douglas.data.AppDataSource

class RemoteDataSource(private val apiHelper: ApiHelper) : AppDataSource {

    override fun requestWeatherBy(city: String) = apiHelper.getWeather(city)

    override fun requestForecastBy(city: String) = apiHelper.getForecast(city)


}