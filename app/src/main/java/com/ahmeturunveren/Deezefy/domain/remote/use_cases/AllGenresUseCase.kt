package com.ahmeturunveren.Deezefy.domain.remote.use_cases

import com.ahmeturunveren.Deezefy.domain.mappers.toGenre
import com.ahmeturunveren.Deezefy.data.models.GenreDtoModel
import com.ahmeturunveren.Deezefy.domain.models.Genre
import com.ahmeturunveren.Deezefy.domain.remote.impl.DeezerDataImpl

class AllGenresUseCase(
    private val deezerDataImpl: DeezerDataImpl
) {

    suspend operator fun invoke(): List<Genre> =
        deezerDataImpl.getGenre().data!!.data!!.map { dtoModel: GenreDtoModel -> dtoModel.toGenre() }

}