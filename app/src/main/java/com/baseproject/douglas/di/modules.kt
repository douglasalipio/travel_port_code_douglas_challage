package com.baseproject.douglas.di

import android.app.Application
import com.baseproject.douglas.data.AppDataSource
import com.baseproject.douglas.data.AppRepository
import com.baseproject.douglas.data.feature.city.ProductDtoMapper
import com.baseproject.douglas.data.feature.weather.ProductDetailDtoMapper
import com.baseproject.douglas.data.remote.ApiHelper
import com.baseproject.douglas.data.remote.RemoteDataSource
import com.baseproject.douglas.data.remote.ServiceAppFactory
import com.baseproject.douglas.feature.weather.view.WeatherActivity
import com.baseproject.douglas.feature.weather.WeatherModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [WeatherModule::class])
    abstract fun productAcitivity(): WeatherActivity
}

@Module
class AppModule {

    @Provides
    @Reusable
    internal fun provideContext(application: Application): Application = application
}

@Module
class RepositoryModule {

    @Provides
    @Reusable
    internal fun provideAppRepository(remoteDataSource: RemoteDataSource): AppDataSource =
        AppRepository(remoteDataSource)

}

@Module
class MapperModule {
    @Provides
    @Reusable
    internal fun provideProductMapper() = ProductDtoMapper()

    @Provides
    @Reusable
    internal fun provideProductDetailMapper() = ProductDetailDtoMapper()
}

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource =
        RemoteDataSource(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create()
}
