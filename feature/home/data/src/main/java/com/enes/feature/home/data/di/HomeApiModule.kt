package com.enes.feature.home.data.di

import com.enes.feature.home.data.api.HomeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiModule {
    @Provides
    @Singleton
    fun providesHomeApi(retrofit: Retrofit): HomeAPI {
        return retrofit.create(HomeAPI::class.java)
    }

}