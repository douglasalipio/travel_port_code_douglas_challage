package com.baseproject.douglas.feature.weather.view

import com.xwray.groupie.Group
import com.xwray.groupie.GroupDataObserver
import com.xwray.groupie.Item


class WeatherGroup(private val items: List<Item<*>>) : Group {

    override fun getItemCount() = items.size

    override fun getItem(position: Int) = items[position]

    override fun getPosition(item: Item<*>) = items.indexOf(item)

    override fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver) {
    }

    override fun registerGroupDataObserver(groupDataObserver: GroupDataObserver) {
    }
}