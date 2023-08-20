package com.ahmeturunveren.Deezefy.domain.mappers

import com.ahmeturunveren.Deezefy.data.models.ArtistDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Artist

fun ArtistDtoModel.toArtist(): Artist = Artist(
    id = id ?: 0,
    name = name ?: "",
    pictureMedium = pictureMedium ?: "",
    picture = picture ?: ""
)