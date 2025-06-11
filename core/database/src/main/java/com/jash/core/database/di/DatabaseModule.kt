package com.jash.core.database.di

import androidx.room.Room
import com.jash.core.database.MIGRATION_1_2
import com.jash.core.database.PennieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            PennieDatabase::class.java,
            "pennie.db"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }


    single { get<PennieDatabase>().transactionDao }
    single { get<PennieDatabase>().accountDao }
    single { get<PennieDatabase>().categoryDao }
    single { get<PennieDatabase>().budgetDao }


}