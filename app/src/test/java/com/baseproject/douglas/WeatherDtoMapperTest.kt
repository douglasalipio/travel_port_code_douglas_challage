package com.baseproject.douglas

import com.baseproject.douglas.data.feature.forecast.ForecastDto
import com.baseproject.douglas.data.feature.forecast.ForecastDtoMapper
import com.baseproject.douglas.data.feature.forecast.Main
import com.baseproject.douglas.data.feature.forecast.Weather
import com.baseproject.douglas.feature.weather.data.ForecastInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class ForecastDtoMapperTest {

    private val mapper = ForecastDtoMapper()

    @Test
    fun `should validate forecast mapper`() {
        // given
        val forecastDto = mockForecastDto()
        val expectedForecastInfo = mockForecastInfo()
        // when
        val mappingResult = mapper.mapToList(forecastDto)
        // then
        assertEquals(expectedForecastInfo.iconUrl, mappingResult.last().iconUrl)
    }

    private fun mockForecastDto() = ForecastDto(
        listOf(
            com.baseproject.douglas.data.feature.forecast.List(
                10L,
                "2020-02-15 21:00:00",
                Main(10f, 15f),
                listOf(Weather("moderate rain", "iconUrl"))
            )
        )
    )

    private fun mockForecastInfo() = ForecastInfo(
        "http://openweathermap.org/img/wn/iconUrl@2x.png",
        "10",
        "15",
        "2020-02-15 21:00:00",
        "moderate rain"
    )
}
