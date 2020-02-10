package com.baseproject.douglas.data.feature.weather

import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.util.Mapper


class ProductDetailDtoMapper : Mapper<List<ProductDetailDto>, List<WeatherDetail>> {

    override fun map(from: List<ProductDetailDto>) = from.map {
        WeatherDetail(
            id = it.id,
            price = it.price,
            title = it.title,
            imageUrl = it.imageUrl,
            description = it.description,
            allergyInformation = it.allergyInformation
        )
    }
}
