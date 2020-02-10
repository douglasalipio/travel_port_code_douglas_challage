package com.baseproject.douglas.data.feature.weather

import com.google.gson.annotations.SerializedName

data class ProductDetailDto(
    @SerializedName("id")
    var id: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("imageUrl")
    var imageUrl: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("allergyInformation")
    var allergyInformation: String
)
