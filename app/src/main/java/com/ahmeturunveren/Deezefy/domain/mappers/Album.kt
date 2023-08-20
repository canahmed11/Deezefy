package com.ahmeturunveren.Deezefy.domain.mappers

import com.ahmeturunveren.Deezefy.data.models.AlbumDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Album

fun AlbumDtoModel.toAlbum(): Album = Album(
    id = id ?: 0,
    title = title ?: "",
    cover = cover ?: "",
    releaseDate = releaseDate ?: ""
)