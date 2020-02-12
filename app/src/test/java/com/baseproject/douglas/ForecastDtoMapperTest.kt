package com.baseproject.douglas

import com.baseproject.douglas.data.feature.weather.Main
import com.baseproject.douglas.data.feature.weather.Sys
import com.baseproject.douglas.data.feature.weather.WeatherDto
import com.baseproject.douglas.data.feature.weather.WeatherDtoMapper
import com.baseproject.douglas.feature.weather.data.WeatherInfo
import mockWeatherDto
import mockWeatherInfo
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


}
