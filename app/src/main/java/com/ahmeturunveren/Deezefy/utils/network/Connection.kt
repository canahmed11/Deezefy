package com.ahmeturunveren.Deezefy.utils.network

import kotlinx.coroutines.flow.Flow


interface Connection {

    fun observe(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }

}