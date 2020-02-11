package com.baseproject.douglas.data.feature.city

import com.baseproject.douglas.data.feature.weather.ForecastDto
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("clusters")
    val name: String,
    val forecastDtoDetail: kotlin.collections.List<ForecastDto>,
    @SerializedName("list")
    val list: kotlin.collections.List<List>
)

data class List(
    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("weather")
    var weather: kotlin.collections.List<Weather>
)

data class Main(
    @SerializedName("temp")
    var temp: Float? = null,
    @SerializedName("feels_like")
    var feelsLike: Float? = null,
    @SerializedName("humidity")
    var humidity: Int? = null
)

data class Weather(
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("icon")
    var icon: String? = null
)