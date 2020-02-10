package com.baseproject.douglas.feature.weather.view

import com.baseproject.douglas.R
import com.baseproject.douglas.feature.weather.data.SubItem
import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.product_item.view.*


class WeatherItem(
    private val subItem: SubItem,
    private val clickListener: (String) -> Unit
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Glide.with(context).load(subItem.imageUrl).into(photoImg)
            productTitle.text = subItem.title
            productPrice.text = subItem.price
            productSize.text = subItem.size
            setOnClickListener { clickListener(subItem.id.toString()) }
        }
    }

    override fun getLayout() = R.layout.product_item
}