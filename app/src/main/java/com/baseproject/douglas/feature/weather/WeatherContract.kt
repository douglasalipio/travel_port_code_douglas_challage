package com.baseproject.douglas.feature.weather

import com.baseproject.douglas.foundation.BasePresenter
import com.baseproject.douglas.foundation.BaseView
import com.baseproject.douglas.foundation.BaseInteractor
import com.xwray.groupie.Section

interface WeatherContract {

    interface View : BaseView<Presenter> {

        fun showProducts(section: Section)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadData(city: String)
    }

    interface Interactor : BaseInteractor {
        suspend fun requestWeather(
            getWeatherDetailCallback: WeatherInteractor.GetWeatherInfoCallback,
            city: String
        )
    }
}