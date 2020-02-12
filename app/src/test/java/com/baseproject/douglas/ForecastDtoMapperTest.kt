package com.baseproject.douglas

import com.baseproject.douglas.data.feature.weather.Main
import com.baseproject.douglas.data.feature.weather.Sys
import com.baseproject.douglas.data.feature.weather.WeatherDto
import com.baseproject.douglas.data.feature.weather.WeatherDtoMapper
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherDtoMapperTest {

    private val mapper = WeatherDtoMapper()

    @Test
    fun `should validate weather mapper`() {
        // given
        val weatherDto = mockWeatherDto()
        val expectedWeatherInfo = mockWeatherInfo()
        // when
        val mappingResult = mapper.map(weatherDto)
        // then
        assertEquals(expectedWeatherInfo.city, mappingResult.city)
    }

    private fun mockWeatherInfo() = WeatherInfo(
        "city",
        "country",
        "40",
        "20",
        "25",
        mutableListOf()
    )

    private fun mockWeatherDto() =
        WeatherDto(
            "city",
            listOf(),
            Main(1f, 2f, 2),
            "11/11/2019",
            Sys("country")
        )
}
