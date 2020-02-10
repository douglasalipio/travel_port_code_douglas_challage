package com.baseproject.douglas.feature.weather.extensions

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.baseproject.douglas.R
import com.baseproject.douglas.feature.weather.data.WeatherDetail
import com.baseproject.douglas.feature.weather.data.SubItem
import com.baseproject.douglas.feature.weather.view.WeatherGroup
import com.baseproject.douglas.feature.weather.view.WeatherItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_product_detail.view.*

fun List<SubItem>.mapToProductGroup(clickProductDetail: (String) -> Unit): WeatherGroup {
    val productItems = mutableListOf<WeatherItem>()
    forEach { subItem -> productItems.add(WeatherItem(subItem, clickProductDetail)) }
    return WeatherGroup(productItems)
}

fun Activity.showProductDetailDialog(weatherDetail: WeatherDetail) {
    MaterialDialog(this).show {
        customView(R.layout.dialog_product_detail)
        setImage(applicationContext, weatherDetail.imageUrl, view.photoImg)
        cornerRadius(16f)
        title(text = weatherDetail.title)
        positiveButton { dismiss() }
        view.allergyInformation.text = weatherDetail.allergyInformation
        view.productDescription.text = weatherDetail.description
    }
}

private fun setImage(context: Context, imageUrl: String, photoImg: ImageView) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .into(photoImg)
}