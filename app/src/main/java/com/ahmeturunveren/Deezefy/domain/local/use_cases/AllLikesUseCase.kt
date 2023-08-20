package com.ahmeturunveren.Deezefy.domain.local.use_cases

import com.ahmeturunveren.Deezefy.data.local.services.LikeDataSource
import com.ahmeturunveren.Deezefy.data.models.Like
import kotlinx.coroutines.flow.Flow

class AllLikesUseCase(
    private val likeDataSource: LikeDataSource
) {

    operator fun invoke(): Flow<List<Like>> = likeDataSource.getLikes()

}