package com.baseproject.douglas.data.remote

import com.baseproject.douglas.data.feature.city.WeatherDto
import com.baseproject.douglas.data.feature.weather.ForecastDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.openweathermap.org"

interface ApiHelper {

    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = "bd8326266ffeb1b662cf75fadf5dee2a"
    ): Flowable<WeatherDto>

    @GET("data/2.5/forecast")
    fun getForecast(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = "bd8326266ffeb1b662cf75fadf5dee2a"
    ): Flowable<ForecastDto>
}