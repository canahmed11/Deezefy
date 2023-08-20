package com.ahmeturunveren.Deezefy.domain.remote.use_cases

import com.ahmeturunveren.Deezefy.domain.mappers.toAlbum
import com.ahmeturunveren.Deezefy.data.models.AlbumDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Album
import com.ahmeturunveren.Deezefy.domain.remote.impl.DeezerDataImpl

class AllAlbumsUseCase(
    private val deezerDataImpl: DeezerDataImpl
) {

    suspend operator fun invoke(artistId: Int): List<Album> =
        deezerDataImpl.getAlbums(artistId = artistId).data!!.data!!.map { dtoModel: AlbumDtoModel -> dtoModel.toAlbum() }

}