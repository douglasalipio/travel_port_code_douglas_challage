import com.baseproject.douglas.data.feature.forecast.ForecastDto
import com.baseproject.douglas.data.feature.forecast.Weather
import com.baseproject.douglas.data.feature.weather.Main
import com.baseproject.douglas.data.feature.weather.Sys
import com.baseproject.douglas.data.feature.weather.WeatherDto
import com.baseproject.douglas.feature.weather.data.ForecastInfo
import com.baseproject.douglas.feature.weather.data.WeatherInfo

fun mockWeatherInfo() = WeatherInfo(
    "city",
    "country",
    "40",
    "20",
    "25",
    mutableListOf()
)

fun mockWeatherDto() =
    WeatherDto(
        "city",
        listOf(),
        Main(1f, 2f, 2),
        "11/11/2019",
        Sys("country")
    )


fun mockForecastDto() = ForecastDto(
    listOf(
        com.baseproject.douglas.data.feature.forecast.List(
            10L,
            "2020-02-15 21:00:00",
            com.baseproject.douglas.data.feature.forecast.Main(10f, 15f),
            listOf(Weather("moderate rain", "iconUrl"))
        )
    )
)

fun mockForecastInfo() = ForecastInfo(
    "http://openweathermap.org/img/wn/iconUrl@2x.png",
    "10",
    "15",
    "2020-02-15 21:00:00",
    "moderate rain"
)