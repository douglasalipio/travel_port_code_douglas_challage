package com.baseproject.douglas.data.feature.weather


import com.baseproject.douglas.feature.weather.data.WeatherInfo
import com.baseproject.douglas.util.Mapper
import kotlin.collections.List

class WeatherDtoMapper : Mapper<WeatherDto, WeatherInfo> {

    override fun map(from: WeatherDto) = WeatherInfo(
        city = from.name,
        country = from.countryInfo.country,
        humidity = from.main.humidity.toString(),
        feelsLike = from.main.feelsLike.toString(),
        tempeture = from.main.temp.toString()
    )

    override fun mapToList(from: WeatherDto): List<WeatherInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}