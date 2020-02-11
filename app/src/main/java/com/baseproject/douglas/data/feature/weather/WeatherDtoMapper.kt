package com.baseproject.douglas.data.feature.weather

import com.baseproject.douglas.feature.weather.data.ForecastInfo
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import com.baseproject.douglas.util.Mapper
import kotlin.collections.List

class WeatherDtoMapper : Mapper<WeatherDto, WeatherInfo> {

    override fun map(from: WeatherDto): WeatherInfo {
        val forecastList = mutableListOf<ForecastInfo>()
        from.list.forEach {
            forecastList.add(
                ForecastInfo(
                    icon = it.weather?.last()?.icon.orEmpty(),
                    description = it.weather?.last()?.description.orEmpty(),
                    date = it.dt.toString(),
                    humidity = it.main.humidity.toString(),
                    temperature = it.main.temp.toString()
                )
            )
        }
        return WeatherInfo(from.name, forecastList)
    }

    override fun mapToList(from: WeatherDto): List<WeatherInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}