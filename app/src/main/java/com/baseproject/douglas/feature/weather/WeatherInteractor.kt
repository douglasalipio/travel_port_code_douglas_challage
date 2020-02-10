package com.baseproject.douglas.feature.weather


import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.data.feature.city.ProductDtoMapper
import com.baseproject.douglas.data.feature.weather.ProductDetailDtoMapper
import com.baseproject.douglas.feature.weather.data.Product
import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.util.io
import com.baseproject.douglas.util.ui
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val appRepository: AppDataSource,
    private val productMapper: ProductDtoMapper,
    private val productDetailMapper: ProductDetailDtoMapper
) :
    WeatherContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    override fun requestProducts(getProductCallback: GetProductCallback) {
        compositeDisposable.add(
            appRepository.requestProducts()
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe { getProductCallback.onProductLoaded(productMapper.map(it)) }
        )
    }

    override fun requestProductDetail(
        getProductDetailCallback: GetProductDetailCallback,
        productId: String
    ) {
        compositeDisposable.add(
            appRepository.requestProductDetailById(productId)
                .subscribeOn(io())
                .observeOn(ui())
                .doOnError { getProductDetailCallback.onDataNotAvailable(it.message.orEmpty()) }
                .subscribe {
                    getProductDetailCallback.onProductDetailLoaded(productDetailMapper.map(it))
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

