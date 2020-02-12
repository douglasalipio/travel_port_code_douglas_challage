package com.baseproject.douglas.data.feature.forecast

import com.baseproject.douglas.feature.weather.data.ForecastInfo
import com.baseproject.douglas.util.DateHelper
import com.baseproject.douglas.util.Mapper
import kotlin.collections.List

class ForecastDtoMapper : Mapper<ForecastDto, ForecastInfo> {

    override fun mapToList(from: ForecastDto): List<ForecastInfo> {
        val forecastList = mutableListOf<ForecastInfo>()
        from.list.forEach {
            forecastList.add(
                ForecastInfo(
                    iconUrl = "http://openweathermap.org/img/wn/${it.weather.last().icon}@2x.png",
                    description = it.weather.last().description,
                    date = DateHelper.toDateFormat(it.dateUtcString),
                    feelsLike = it.main.feelsLike.toInt().toString(),
                    temperature = it.main.temp.toInt().toString()
                )
            )
        }
        return forecastList
    }

    override fun map(from: ForecastDto): ForecastInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}