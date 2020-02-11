package com.baseproject.douglas.data.remote

import com.baseproject.douglas.data.feature.weather.WeatherDto
import com.baseproject.douglas.data.feature.forecast.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.openweathermap.org"

interface ApiHelper {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = "bd8326266ffeb1b662cf75fadf5dee2a"
    ): WeatherDto

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = "bd8326266ffeb1b662cf75fadf5dee2a"
    ): ForecastDto
}