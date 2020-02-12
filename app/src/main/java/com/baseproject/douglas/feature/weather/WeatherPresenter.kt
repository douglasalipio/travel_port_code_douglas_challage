package com.baseproject.douglas.feature.weather


import com.baseproject.douglas.di.ActivityScoped
import com.baseproject.douglas.feature.weather.data.ForecastInfo
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import com.baseproject.douglas.feature.weather.view.WeatherGroup
import com.baseproject.douglas.feature.weather.view.WeatherHeader
import com.baseproject.douglas.feature.weather.view.WeatherItem
import com.xwray.groupie.Section
import kotlinx.coroutines.*
import javax.inject.Inject

@ActivityScoped
class WeatherPresenter @Inject constructor(private val interactor: WeatherContract.Interactor) :
    WeatherContract.Presenter {

    private var view: WeatherContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as WeatherContract.View
    }

    override fun loadData(city: String) {
        GlobalScope.launch(Dispatchers.Main) {
            interactor.requestWeather(object : WeatherInteractor.GetWeatherInfoCallback {

                override fun onWeatherInfoLoaded(data: WeatherInfo) {
                    val section = Section(WeatherHeader("${data.city}, ${data.country}"))
                    section.add(filterByNextFiveDays(data).forecastList.mapToGroup())
                    view?.showWeatherForecasts(section)
                }

                override fun onDataNotAvailable(strError: String) {
                    view?.showDataError()
                }
            }, city)
        }
    }

    private fun filterByNextFiveDays(weatherInfo: WeatherInfo): WeatherInfo {
        weatherInfo.forecastList = weatherInfo.forecastList.distinctBy { it.date }.toMutableList()
        return weatherInfo
    }

    private fun List<ForecastInfo>.mapToGroup(): WeatherGroup {
        val productItems = mutableListOf<WeatherItem>()
        forEach { subItem -> productItems.add(WeatherItem(subItem)) }
        return WeatherGroup(productItems)
    }

    override fun dropView() {
        view = null
    }
}