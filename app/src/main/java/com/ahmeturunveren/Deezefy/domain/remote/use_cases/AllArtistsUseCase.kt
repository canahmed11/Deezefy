package com.ahmeturunveren.Deezefy.domain.remote.use_cases

import com.ahmeturunveren.Deezefy.domain.mappers.toArtist
import com.ahmeturunveren.Deezefy.data.models.ArtistDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Artist
import com.ahmeturunveren.Deezefy.domain.remote.impl.DeezerDataImpl

class AllArtistsUseCase(
    private val deezerDataImpl: DeezerDataImpl
) {

    suspend operator fun invoke(genreId: Int): List<Artist> =
        deezerDataImpl.getArtists(genreId = genreId).data!!.data!!.map { dtoModel: ArtistDtoModel -> dtoModel.toArtist() }

}