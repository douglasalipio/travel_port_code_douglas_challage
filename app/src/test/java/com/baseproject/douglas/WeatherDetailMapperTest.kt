package com.baseproject.douglas

import com.baseproject.douglas.data.feature.weather.ProductDetailDtoMapper
import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Test

class WeatherDetailMapperTest {

    private val mapper = ProductDetailDtoMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDetailDto = listOf(mockProductDetailDto())
        val expectedProductDetail = mockProductDetail()
        // when
        val mappingResult = mapper.map(productDetailDto)
        // then
        assertThat(mappingResult, hasItem((expectedProductDetail)))
    }

}