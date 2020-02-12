package com.baseproject.douglas

import com.baseproject.douglas.feature.weather.WeatherContract
import com.baseproject.douglas.feature.weather.WeatherInteractor
import com.baseproject.douglas.feature.weather.WeatherPresenter
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import com.xwray.groupie.Section
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import mockWeatherInfo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.*

@ExperimentalCoroutinesApi
class WeatherPresenterTest {
    @Mock
    private lateinit var view: WeatherContract.View
    @Mock
    private lateinit var interactor: WeatherContract.Interactor
    @Captor
    private lateinit var getWeatherCallbackCaptor: ArgumentCaptor<WeatherInteractor.GetWeatherInfoCallback>

    private lateinit var presenter: WeatherPresenter
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = WeatherPresenter(interactor)
        presenter.takeView(view)
        Dispatchers.setMain(mainThreadSurrogate)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `should load a list of weather`() {
        runBlocking {
            launch(Dispatchers.Main) {
                presenter.loadData("Dublin")
                verify(interactor).requestWeather(capture(getWeatherCallbackCaptor), "Dublin")
                getWeatherCallbackCaptor.value.onWeatherInfoLoaded(mockWeatherInfo())
                verify(view).showWeatherForecasts(Section())
            }
        }
    }

    @Test
    fun `should return a error`() {
        runBlocking {
            launch(Dispatchers.Main) {
                presenter.loadData("Dublin")
                verify(interactor).requestWeather(capture(getWeatherCallbackCaptor), "Dublin")
                getWeatherCallbackCaptor.value.onDataNotAvailable("data not available.")
                verify(view).showDataError()
            }
        }
    }
}