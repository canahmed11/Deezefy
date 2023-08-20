package com.ahmeturunveren.Deezefy.domain.remote.use_cases

import com.ahmeturunveren.Deezefy.domain.mappers.toTrack
import com.ahmeturunveren.Deezefy.data.models.TrackDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Track
import com.ahmeturunveren.Deezefy.domain.remote.impl.DeezerDataImpl

class AllTracksUseCase(
    private val deezerDataImpl: DeezerDataImpl
) {

    suspend operator fun invoke(albumId: Int): List<Track> =
        deezerDataImpl.getTracks(albumId = albumId).data!!.data!!.map { dtoModel: TrackDtoModel -> dtoModel.toTrack() }

}