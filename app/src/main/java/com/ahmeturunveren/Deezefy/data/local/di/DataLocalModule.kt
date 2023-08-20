package com.ahmeturunveren.Deezefy.data.local.di

import androidx.room.Room
import com.ahmeturunveren.Deezefy.data.local.RoomDB
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val dataLocalModule: Module = module {

    single {
        Room.databaseBuilder(context = androidContext(), RoomDB::class.java, "like.sqlite")
            .createFromAsset(databaseFilePath = "like.sqlite").build().getDao()
    }

}