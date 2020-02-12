package com.baseproject.douglas

import com.baseproject.douglas.data.feature.forecast.ForecastDtoMapper
import mockForecastDto
import mockForecastInfo
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
}
