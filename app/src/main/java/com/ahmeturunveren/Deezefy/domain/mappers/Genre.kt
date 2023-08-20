package com.ahmeturunveren.Deezefy.domain.mappers

import com.ahmeturunveren.Deezefy.data.models.GenreDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Genre

fun GenreDtoModel.toGenre(): Genre = Genre(id = id ?: 0, name = name ?: "", picture = picture ?: "")