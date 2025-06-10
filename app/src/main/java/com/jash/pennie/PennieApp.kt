package com.jash.pennie

import android.app.Application
import android.os.Build
import com.jash.feature_auth.auth_data.di.authDataModule
import com.google.firebase.BuildConfig
import com.jash.core.data.di.coreDataModule
import com.jash.feature_auth.auth_presentation.di.authViewModelModule
import com.jash.pennie.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PennieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@PennieApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,

                )
        }
    }
}