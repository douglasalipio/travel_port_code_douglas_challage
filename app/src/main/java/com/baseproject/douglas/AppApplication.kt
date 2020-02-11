package com.baseproject.douglas

import com.baseproject.douglas.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AppApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        initThreeTen()
        return buildDaggerComponent()
    }

    private fun buildDaggerComponent() = DaggerAppComponent.builder().application(this).build()
    private fun initThreeTen() = AndroidThreeTen.init(this)
}