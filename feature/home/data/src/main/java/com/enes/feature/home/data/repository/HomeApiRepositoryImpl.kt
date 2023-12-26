package com.enes.feature.home.data.repository

import com.enes.common.data.base.BaseRepository
import com.enes.common.data.dto.NetworkWrapper
import com.enes.common.data.util.mapResponseToEntity
import com.enes.feature.home.data.datasource.HomeDataSource
import com.enes.feature.home.data.mapper.toGetAllCharacterResponseModelEntity
import com.enes.feature.home.domain.HomeApiRepository
import com.enes.feature.home.domain.entity.GetAllCharacterResponseModelEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeApiRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeApiRepository, BaseRepository() {
    override suspend fun getAllCharacter(): Flow<NetworkWrapper<GetAllCharacterResponseModelEntity>> {
        return safeApiCall { homeDataSource.getAllCharacters() }.mapResponseToEntity { it.toGetAllCharacterResponseModelEntity() }
    }
}