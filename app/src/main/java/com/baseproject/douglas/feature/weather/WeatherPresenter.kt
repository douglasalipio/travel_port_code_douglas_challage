package com.baseproject.douglas.feature.weather


import android.util.Log
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

    override fun loadData() {
        GlobalScope.launch(Dispatchers.Main) {
            interactor.requestWeather(object : WeatherInteractor.GetWeatherInfoCallback {

                override fun onWeatherInfoLoaded(data: WeatherInfo) {
                    Log.e("test", "")
                    val section = Section(WeatherHeader(data.city))
                    section.add(data.forecastList.mapToGroup())
                    view?.showProducts(section)
                }

                override fun onDataNotAvailable(strError: String) {
                    view?.showDataError()
                }
            }, "Dublin")
        }
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