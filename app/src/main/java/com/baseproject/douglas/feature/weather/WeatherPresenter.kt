package com.baseproject.douglas.feature.weather


import com.baseproject.douglas.di.ActivityScoped
import com.baseproject.douglas.feature.weather.data.Product
import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.feature.weather.extensions.mapToProductGroup
import com.baseproject.douglas.feature.weather.view.WeatherHeader
import com.xwray.groupie.Section
import javax.inject.Inject

@ActivityScoped
class WeatherPresenter @Inject constructor(private val interactor: WeatherContract.Interactor) :
    WeatherContract.Presenter {

    private var view: WeatherContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as WeatherContract.View
    }

    override fun loadData() {
        interactor.requestProducts(object : WeatherInteractor.GetProductCallback {

            override fun onProductLoaded(data: Product) {
                calculateTotalOfProducts(data)
            }

            override fun onDataNotAvailable(strError: String) {
                view?.showDataError()
            }
        })
    }

    override fun loadProductDetail(productId: String) {
        interactor.requestProductDetail(object : WeatherInteractor.GetProductDetailCallback {

            override fun onProductDetailLoaded(data: List<WeatherDetail>) {
                view?.showProductDetail(data.first { it.id == productId })
            }

            override fun onDataNotAvailable(strError: String) {
                view?.showDataError()
            }
        }, productId)
    }

    private fun calculateTotalOfProducts(data: Product) {
        val totalItems = data.categories.map { it.subItems.size }.sum()
        view?.setUpGridList(totalItems, data)
    }

    override fun mapProductItems(data: Product, clickProductDetail: (String) -> Unit) {
        data.categories.forEach { category ->
            val section = Section(WeatherHeader(category.tag))
            val group = category.subItems.mapToProductGroup(clickProductDetail)
            section.add(group)
            view?.showProducts(section)
        }
    }

    override fun dropView() {
        view = null
    }
}