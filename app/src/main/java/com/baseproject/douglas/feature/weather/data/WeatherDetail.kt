package com.baseproject.douglas.feature.weather.data

data class WeatherDetail(
    var id: String,
    var price: String,
    var title: String,
    var imageUrl: String,
    var description: String,
    var allergyInformation: String
)