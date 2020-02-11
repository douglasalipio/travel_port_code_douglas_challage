package com.baseproject.douglas.data

import com.baseproject.douglas.data.feature.city.WeatherDto
import com.baseproject.douglas.data.feature.weather.ForecastDto
import com.baseproject.douglas.data.remote.RemoteDataSource
import io.reactivex.Flowable
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    AppDataSource {

    override fun requestWeatherBy(city: String) = remoteDataSource.requestWeatherBy(city)

    override fun requestForecastBy(city: String) = remoteDataSource.requestForecastBy(city)

}