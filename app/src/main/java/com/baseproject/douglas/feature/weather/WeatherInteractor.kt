package com.baseproject.douglas.feature.weather


import android.util.Log
import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.data.feature.forecast.ForecastDtoMapper
import com.baseproject.douglas.data.feature.weather.WeatherDtoMapper
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val forecastMapper: ForecastDtoMapper,
    private val weatherMapper: WeatherDtoMapper
) :
    WeatherContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override suspend fun requestWeather(
        getWeatherDetailCallback: GetWeatherInfoCallback,
        city: String
    ) {
        withContext(Dispatchers.IO) {
            val weatherDto = appRepository.requestWeatherBy(city)
            val forecastDto = appRepository.requestForecastBy(city)
            val weather = weatherMapper.map(weatherDto)
            weather.forecastList.addAll(forecastMapper.mapToList(forecastDto).toMutableList())
            getWeatherDetailCallback.onWeatherInfoLoaded(weather)
        }
    }

    override fun dispose() = compositeDisposable.dispose()

    interface GetWeatherInfoCallback {

        fun onWeatherInfoLoaded(data: WeatherInfo)

        fun onDataNotAvailable(strError: String)
    }
}

