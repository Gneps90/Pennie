package com.jash.pennie

import android.app.Application
import com.jash.core.data.di.coreDataModule
import com.jash.core.database.di.databaseModule
import com.jash.feature_auth.auth_data.di.authDataModule
import com.jash.feature_auth.auth_presentation.di.authViewModelModule
import com.jash.feature_overview.data.di.overviewDataModule
import com.jash.feature_overview.domain.di.overviewDomainModule
import com.jash.feature_overview.presentation.di.overviewViewModelModule
import com.jash.pennie.di.appModule
import com.pennie.core.presentation.designsystem.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PennieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@PennieApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                databaseModule,
                overviewDataModule, // Add module
                overviewDomainModule, // Add module
                overviewViewModelModule // Add module
            )
        }
    }
}