//package com.baseproject.douglas
//
//import com.baseproject.douglas.feature.weather.WeatherContract
//import com.baseproject.douglas.feature.weather.WeatherInteractor
//import com.baseproject.douglas.feature.weather.WeatherPresenter
//import com.nhaarman.mockitokotlin2.any
//import com.nhaarman.mockitokotlin2.capture
//import com.nhaarman.mockitokotlin2.verify
//import org.junit.Before
//import org.junit.Test
//import org.mockito.*
//import org.mockito.ArgumentMatchers.anyString
//
//
//class WeatherPresenterTest {
//    @Mock
//    private lateinit var view: WeatherContract.View
//    @Mock
//    private lateinit var interactor: WeatherContract.Interactor
//    @Captor
//    private lateinit var getWeatherCallbackCaptor: ArgumentCaptor<WeatherInteractor.GetProductCallback>
//    @Captor
//    private lateinit var getWeatherDetailCallbackCaptor: ArgumentCaptor<WeatherInteractor.GetProductDetailCallback>
//    private lateinit var presenter: WeatherPresenter
//    private val clickProductDetail: (String) -> Unit = {}
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        presenter = WeatherPresenter(interactor)
//        presenter.takeView(view)
//    }
//
//    @Test
//    fun `should return a list of sections`() {
//        presenter.loadData()
//        presenter.mapProductItems(mockProducts(), clickProductDetail)
//
//        verify(interactor).requestProducts(capture(getWeatherCallbackCaptor))
//        getWeatherCallbackCaptor.value.onProductLoaded(mockProducts())
//
//        verify(view).setUpGridList(1, mockProducts())
//        verify(view).showProducts(any())
//    }
//
//    @Test
//    fun `should show a error message after loading productDetail`() {
//        presenter.loadProductDetail("id")
//        verify(interactor).requestProductDetail(capture(getWeatherDetailCallbackCaptor), anyString())
//        getWeatherDetailCallbackCaptor.value.onDataNotAvailable("data not available.")
//        verify(view).showDataError()
//    }
//
//    @Test
//    fun `should show a error message after loading products`() {
//        presenter.loadData()
//        verify(interactor).requestProducts(capture(getWeatherCallbackCaptor))
//        getWeatherCallbackCaptor.value.onDataNotAvailable("data not available.")
//        verify(view).showDataError()
//    }
//}