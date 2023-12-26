package com.enes.feature.home.data.mapper

import com.enes.feature.home.data.model.GetAllCharacterResponseModel
import com.enes.feature.home.data.model.Info
import com.enes.feature.home.data.model.Location
import com.enes.feature.home.data.model.Origin
import com.enes.feature.home.data.model.Result
import com.enes.feature.home.domain.entity.GetAllCharacterResponseModelEntity
import com.enes.feature.home.domain.entity.InfoEntity
import com.enes.feature.home.domain.entity.LocationEntity
import com.enes.feature.home.domain.entity.OriginEntity
import com.enes.feature.home.domain.entity.ResultEntity

fun GetAllCharacterResponseModel.toGetAllCharacterResponseModelEntity() =
    GetAllCharacterResponseModelEntity(
        info = info?.toInfoEntity(),
        results = results?.map {
            it?.toResultEntity()
        }
    )

fun Info.toInfoEntity() = InfoEntity(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)

fun Result.toResultEntity() = ResultEntity(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    location = location?.toLocationEntity(),
    name = name,
    origin = origin?.toOriginEntity(),
    species = species,
    status = status,
    type = type,
    url = url
)

fun Location.toLocationEntity() = LocationEntity(
    name = name,
    url = url
)

fun Origin.toOriginEntity() = OriginEntity(
    name = name,
    url = url
)