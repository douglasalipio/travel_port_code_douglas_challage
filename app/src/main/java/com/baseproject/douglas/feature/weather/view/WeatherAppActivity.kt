package com.baseproject.douglas.feature.weather.view

import android.os.Bundle
import android.util.Log
import com.baseproject.douglas.R
import com.baseproject.douglas.feature.weather.WeatherContract
import com.baseproject.douglas.util.initGridLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class WeatherAppActivity : DaggerAppCompatActivity(), WeatherContract.View {
    @Inject
    internal lateinit var presenter: WeatherContract.Presenter
    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        presenter.takeView(this)
        presenter.loadData()
    }

    private fun initComponents() {
        weatherList.initGridLayout(this, adapter)
    }

//    override fun setUpGridList(totalItems: Int, product: Product) {
//        //adapter.spanCount = totalItems
//        productList.initGridLayout(this, adapter, adapter.spanCount)
//        presenter.mapProductItems(product, clickProductDetail)
//    }

//    override fun showProductDetail(weatherDetail: WeatherDetail) {
//        // showProductDetailDialog(weatherDetail)
//    }

    override fun showProducts(section: Section) {
        adapter.add(section)
    }

    //  private fun onProductDetailClicked(productId: String) = presenter.loadProductDetail(productId)

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
