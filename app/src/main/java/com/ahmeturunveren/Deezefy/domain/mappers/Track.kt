package com.ahmeturunveren.Deezefy.domain.mappers

import com.ahmeturunveren.Deezefy.data.models.TrackDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Track

fun TrackDtoModel.toTrack(): Track = Track(
    id = id ?: 0,
    title = title ?: "",
    md5Image = md5Image ?: "",
    duration = duration ?: 0,
    preview = preview ?: ""
)