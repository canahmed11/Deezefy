package com.ahmeturunveren.Deezefy.domain.local.use_cases

import com.ahmeturunveren.Deezefy.data.local.services.LikeDataSource
import com.ahmeturunveren.Deezefy.data.models.Like

class DeleteLikeUseCase(
    private val likeDataSource: LikeDataSource
) {

    suspend operator fun invoke(like: Like): Unit = likeDataSource.deleteLike(like = like)

}