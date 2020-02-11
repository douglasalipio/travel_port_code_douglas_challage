package com.baseproject.douglas.feature.weather


import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.data.feature.forecast.ForecastDtoMapper
import com.baseproject.douglas.data.feature.weather.WeatherDtoMapper
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val forecastMapper: ForecastDtoMapper,
    private val weatherMapper: WeatherDtoMapper
) :
    WeatherContract.Interactor {

    override suspend fun requestWeather(
        getWeatherDetailCallback: GetWeatherInfoCallback,
        city: String
    ) {
        GlobalScope.launch(Dispatchers.Main) {
            val weatherDto = withContext(Dispatchers.IO) { appRepository.requestWeatherBy(city) }
            val forecastDto = withContext(Dispatchers.IO) { appRepository.requestForecastBy(city) }
            val weather = weatherMapper.map(weatherDto)
            weather.forecastList.addAll(forecastMapper.mapToList(forecastDto).toMutableList())
            getWeatherDetailCallback.onWeatherInfoLoaded(weather)
        }
    }

    interface GetWeatherInfoCallback {

        fun onWeatherInfoLoaded(data: WeatherInfo)

        fun onDataNotAvailable(strError: String)
    }
}

