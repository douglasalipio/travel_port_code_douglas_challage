package com.baseproject.douglas

import com.baseproject.douglas.feature.weather.WeatherContract
import com.baseproject.douglas.feature.weather.WeatherInteractor
import com.baseproject.douglas.feature.weather.WeatherPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import com.xwray.groupie.Section
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import mockWeatherInfo
import org.junit.After
import org.junit.Before
import org.junit.Rule
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
    private val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = WeatherPresenter(interactor)
        presenter.takeView(view)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `should load a list of weather`() {
        runBlockingTest {
            launch(Dispatchers.Main) {
                presenter.loadData("Dublin")
                verify(interactor).requestWeather(capture(getWeatherCallbackCaptor), any())
                getWeatherCallbackCaptor.value.onWeatherInfoLoaded(mockWeatherInfo())
                verify(view).showWeatherForecasts(any())
            }
        }
    }

    @Test
    fun `should return a error`() {
        runBlockingTest {
            presenter.loadData("Dublin")
            verify(interactor).requestWeather(capture(getWeatherCallbackCaptor), any())
            getWeatherCallbackCaptor.value.onDataNotAvailable("data not available.")
            verify(view).showDataError()
        }
    }
}