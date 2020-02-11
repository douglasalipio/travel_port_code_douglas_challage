package com.baseproject.douglas

import org.hamcrest.CoreMatchers.hasItem
import org.junit.Assert.assertThat
import org.junit.Test

class WeatherDtoMapperTest {

    private val mapper = CityDtoMapper()

    @Test
    fun `should map section model to section`() {
        // given
        val productDto = mockProductDto()
        val expectedProduct = mockProducts()
        // when
        val mappingResult = mapper.map(productDto)
        // then
        assertThat(mappingResult.categories, hasItem((expectedProduct.categories.last())))
    }

}
