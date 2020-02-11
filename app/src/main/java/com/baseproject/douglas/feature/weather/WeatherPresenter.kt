package com.baseproject.douglas.feature.weather


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

//            override fun onWeatherInfoLoaded(data: WeatherDetail) {
//                calculateTotalOfProducts(data)
//            }

                override fun onWeatherInfoLoaded(data: WeatherInfo) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }


                override fun onDataNotAvailable(strError: String) {
                    view?.showDataError()
                }
            }, "Dublin")
        }
    }


//    private fun calculateTotalOfProducts(data: Product) {
//        val totalItems = data.categories.map { it.subItems.size }.sum()
//        view?.setUpGridList(totalItems, data)
//    }

//    override fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit) {
//        data.categories.forEach { category ->
//            val section = Section(WeatherHeader(category.tag))
//            val group = category.subItems.mapToProductGroup(clickProductDetail)
//            section.add(group)
//            view?.showProducts(section)
//        }
//    }

    override fun dropView() {
        view = null
    }
}