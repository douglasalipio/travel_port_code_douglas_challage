package com.baseproject.douglas.feature.weather

import com.baseproject.douglas.feature.weather.data.Product
import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.foundation.BasePresenter
import com.baseproject.douglas.foundation.BaseView
import com.baseproject.douglas.foundation.BaseInteractor
import com.xwray.groupie.Section

interface WeatherContract {

    interface View : BaseView<Presenter> {

        fun showProducts(section: Section)
        fun showDataError()
        fun setUpGridList(totalItems: Int, product: Product)
        fun showProductDetail(weatherDetail: WeatherDetail)
    }

    interface Presenter : BasePresenter {
        fun loadData()
        fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit)
        fun loadProductDetail(productId: String)
    }

    interface Interactor : BaseInteractor {
        fun requestProductDetail(
            getWeatherDetailCallback: WeatherInteractor.GetProductDetailCallback,
            productId: String
        )

        fun requestProducts(getWeatherCallback: WeatherInteractor.GetProductCallback)
    }
}