package com.ahmeturunveren.Deezefy.utils.di

import com.ahmeturunveren.Deezefy.utils.network.NetworkConnection
import com.ahmeturunveren.Deezefy.utils.repos.DateRepo
import com.ahmeturunveren.Deezefy.utils.repos.DurationRepo
import com.ahmeturunveren.Deezefy.utils.repos.ImageRepo
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val utilsModule: Module = module {

    single {
        NetworkConnection(context = androidContext())
    }

    single {
        DateRepo()
    }

    single {
        DurationRepo()
    }

    factory {
        ImageRepo()
    }

}