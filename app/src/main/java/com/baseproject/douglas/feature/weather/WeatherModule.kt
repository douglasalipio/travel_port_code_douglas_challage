package com.baseproject.douglas.feature.weather

import com.baseproject.douglas.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class WeatherModule {

    @ActivityScoped
    @Binds
    internal abstract fun featurePresenter(presenter: WeatherPresenter): WeatherContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun featureInteractor(interactor: WeatherInteractor): WeatherContract.Interactor
}