package com.baseproject.douglas.feature.weather


import android.util.Log
import com.baseproject.douglas.di.ActivityScoped
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import com.xwray.groupie.Section
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
                }

                override fun onDataNotAvailable(strError: String) {
                    view?.showDataError()
                }
            }, "Dublin")
        }
    }

    override fun dropView() {
        view = null
    }
}