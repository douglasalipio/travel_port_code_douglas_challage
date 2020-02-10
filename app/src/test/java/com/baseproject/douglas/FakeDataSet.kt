package com.baseproject.douglas

import com.baseproject.douglas.data.feature.city.Cluster
import com.baseproject.douglas.data.feature.city.Item
import com.baseproject.douglas.data.feature.city.ProductDto
import com.baseproject.douglas.data.feature.weather.ProductDetailDto
import com.baseproject.douglas.feature.weather.data.Category
import com.baseproject.douglas.feature.weather.data.Product
import com.baseproject.douglas.feature.weather.data.SubItem
import com.baseproject.douglas.feature.weather.data.WeatherDetail


fun mockProducts() =
    Product(mockCategories())
fun mockProductDto() = ProductDto(mockCluster())

fun mockCategories() = listOf(
    Category(
        tag = "tag1",
        subItems = mockSubItems()
    )
)

fun mockCluster() = listOf(
    Cluster(
        tag = "tag1",
        items = mockItem()
    )
)

fun mockSubItems() = listOf(
    SubItem(
        id = 123,
        price = "12,00",
        title = "Title 1",
        size = "Small",
        imageUrl = "url1"
    )
)

fun mockItem() = listOf(
    Item(
        id = 123,
        price = "12,00",
        title = "Title 1",
        size = "Small",
        imageUrl = "url1"
    )
)

fun mockProductDetail() =
    WeatherDetail(
        id = "10",
        price = "€20",
        title = "Bananas Pacovan",
        imageUrl = "url_img",
        description = "Organic. Suitable for vegetarians",
        allergyInformation = "May contain traces of Sesame Seeds"
    )

fun mockProductDetails() = listOf(
    WeatherDetail(
        id = "10",
        price = "€20",
        title = "Bananas Pacovan",
        imageUrl = "url_img",
        description = "Organic. Suitable for vegetarians",
        allergyInformation = "May contain traces of Sesame Seeds"
    )
)

fun mockProductDetailDto() = ProductDetailDto(
    id = "10",
    price = "€20",
    title = "Bananas Pacovan",
    imageUrl = "url_img",
    description = "Organic. Suitable for vegetarians",
    allergyInformation = "May contain traces of Sesame Seeds"
)
