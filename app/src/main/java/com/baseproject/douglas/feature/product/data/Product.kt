package com.baseproject.douglas.feature.product.data

data class Product(val categories: List<Category>)

data class Category(
    val tag: String,
    val subItems: List<SubItem>
)

data class SubItem(
    var id: Int,
    var price: String,
    var title: String,
    var size: String,
    var imageUrl: String
)