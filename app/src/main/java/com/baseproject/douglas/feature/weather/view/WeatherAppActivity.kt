package com.baseproject.douglas.feature.weather.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    }

    override fun onStart() {
        super.onStart()
        presenter.loadData("Limerick")
        presenter.loadData("Rio de Janeiro")
        presenter.loadData("Beijing")
    }

    private fun initComponents() {
        weatherList.initGridLayout(this, adapter)
    }

    override fun showWeatherForecasts(section: Section) {
        adapter.add(section)
    }

    override fun showDataError() {
        Toast.makeText(this, "Connection error", Toast.LENGTH_LONG).show()
    }
}
