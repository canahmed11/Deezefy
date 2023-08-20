package com.ahmeturunveren.Deezefy

import android.app.Application
import com.ahmeturunveren.Deezefy.data.local.di.dataLocalModule
import com.ahmeturunveren.Deezefy.data.remote.di.dataRemoteModule
import com.ahmeturunveren.Deezefy.domain.local.di.domainLocalModule
import com.ahmeturunveren.Deezefy.domain.remote.di.domainRemoteModule
import com.ahmeturunveren.Deezefy.presentation.di.vmModule
import com.ahmeturunveren.Deezefy.utils.di.utilsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BeatifyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BeatifyApp)
            modules(
                dataLocalModule,
                dataRemoteModule,
                domainLocalModule,
                domainRemoteModule,
                vmModule,
                utilsModule
            )
        }
    }

}