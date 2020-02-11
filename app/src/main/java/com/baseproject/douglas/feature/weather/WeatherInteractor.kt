package com.baseproject.douglas.feature.weather


import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.feature.weather.data.Product
import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.util.io
import com.baseproject.douglas.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val cityMapper: CityDtoMapper,
    private val weatherMapper: WeatherDtoMapper
) :
    WeatherContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun requestProducts(getProductCallback: GetProductCallback) {
        compositeDisposable.add(
            appRepository.requestWeatherBy()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe { getProductCallback.onProductLoaded(cityMapper.map(it)) }
        )
    }

    override fun requestProductDetail(
        getProductDetailCallback: GetProductDetailCallback,
        productId: String
    ) {
        compositeDisposable.add(
            appRepository.requestForecastBy(productId)
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductDetailCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe {
                    getProductDetailCallback.onProductDetailLoaded(weatherMapper.map(it))
                }
        )
    }

    override fun dispose() = compositeDisposable.dispose()

    interface GetProductCallback {

        fun onProductLoaded(data: Product)

        fun onDataNotAvailable(strError: String)
    }

    interface GetProductDetailCallback {

        fun onProductDetailLoaded(data: List<WeatherDetail>)

        fun onDataNotAvailable(strError: String)
    }

}

