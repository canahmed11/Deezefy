package com.ahmeturunveren.Deezefy.domain.remote.di

import com.ahmeturunveren.Deezefy.domain.remote.impl.DeezerDataImpl
import com.ahmeturunveren.Deezefy.domain.remote.use_cases.AllAlbumsUseCase
import com.ahmeturunveren.Deezefy.domain.remote.use_cases.AllArtistsUseCase
import com.ahmeturunveren.Deezefy.domain.remote.use_cases.AllGenresUseCase
import com.ahmeturunveren.Deezefy.domain.remote.use_cases.AllTracksUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val domainRemoteModule: Module = module {

    single {
        DeezerDataImpl(deezerDataSource = get())
    }

    single {
        AllAlbumsUseCase(deezerDataImpl = get())
    }

    single {
        AllArtistsUseCase(deezerDataImpl = get())
    }

    single {
        AllGenresUseCase(deezerDataImpl = get())
    }

    single {
        AllTracksUseCase(deezerDataImpl = get())
    }

}