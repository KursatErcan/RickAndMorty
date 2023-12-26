package com.enes.feature.home.data.datasource

import com.enes.feature.home.data.api.HomeAPI
import com.enes.feature.home.data.model.GetAllCharacterResponseModel
import retrofit2.Response
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(private val homeApi: HomeAPI) : HomeDataSource {

    override suspend fun getAllCharacters(): Response<GetAllCharacterResponseModel> {
        return homeApi.gelAllCharacters()
    }

}