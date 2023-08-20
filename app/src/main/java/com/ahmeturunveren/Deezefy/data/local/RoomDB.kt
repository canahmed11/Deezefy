package com.ahmeturunveren.Deezefy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmeturunveren.Deezefy.data.local.services.LikeDataSource
import com.ahmeturunveren.Deezefy.data.models.Like

@Database(entities = [Like::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun getDao(): LikeDataSource
}