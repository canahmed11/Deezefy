package com.ahmeturunveren.Deezefy.domain.remote.services

import com.ahmeturunveren.Deezefy.data.models.AlbumDto
import com.ahmeturunveren.Deezefy.data.models.ArtistDto
import com.ahmeturunveren.Deezefy.data.models.GenreDto
import com.ahmeturunveren.Deezefy.data.models.TrackDto
import com.ahmeturunveren.Deezefy.data.response.BeatifyResponse

interface DeezerResponse {
    suspend fun getGenre(): BeatifyResponse<GenreDto>
    suspend fun getArtists(genreId: Int): BeatifyResponse<ArtistDto>
    suspend fun getAlbums(artistId: Int): BeatifyResponse<AlbumDto>
    suspend fun getTracks(albumId: Int): BeatifyResponse<TrackDto>
}