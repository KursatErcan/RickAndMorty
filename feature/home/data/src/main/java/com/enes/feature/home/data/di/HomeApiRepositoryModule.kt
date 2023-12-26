package com.enes.feature.home.data.di

import com.enes.feature.home.data.datasource.HomeDataSource
import com.enes.feature.home.data.repository.HomeApiRepositoryImpl
import com.enes.feature.home.domain.HomeApiRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiRepositoryModule {

    @Provides
    @Singleton
    fun provideHomeApiRepository(homeDataSource: HomeDataSource): HomeApiRepository {
        return HomeApiRepositoryImpl(homeDataSource)
    }
}
