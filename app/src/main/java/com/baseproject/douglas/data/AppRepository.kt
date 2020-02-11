package com.baseproject.douglas.data

import com.baseproject.douglas.data.remote.RemoteDataSource
import javax.inject.Inject


class AppRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    AppDataSource {

    override suspend fun requestWeatherBy(city: String) = remoteDataSource.requestWeatherBy(city)

    override suspend fun requestForecastBy(city: String) = remoteDataSource.requestForecastBy(city)

}