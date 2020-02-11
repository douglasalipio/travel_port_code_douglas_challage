package com.baseproject.douglas.data.feature.forecast

import com.baseproject.douglas.feature.weather.data.ForecastInfo
import com.baseproject.douglas.util.DateHelper
import com.baseproject.douglas.util.Mapper
import org.threeten.bp.DateTimeUtils
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import java.util.*
import kotlin.collections.List

class ForecastDtoMapper : Mapper<ForecastDto, ForecastInfo> {

    override fun mapToList(from: ForecastDto): List<ForecastInfo> {
        val forecastList = mutableListOf<ForecastInfo>()
        from.list.forEach {
            forecastList.add(
                ForecastInfo(
                    iconUrl = "http://openweathermap.org/img/wn/${it.weather.last().icon}@2x.png",
                    description = it.weather.last().description,
                    date = DateHelper.toDateFormatted(it.dt),
                    feelsLike = it.main.feelsLike.toString(),
                    temperature = it.main.temp.toString()
                )
            )
        }
        return forecastList
    }

    override fun map(from: ForecastDto): ForecastInfo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}