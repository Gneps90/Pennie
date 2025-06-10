package com.jash.core.database.di

import androidx.room.Room
import com.jash.core.database.PennieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            PennieDatabase::class.java,
            "pennie.db"
        ).build()
    }


    single {
        get<PennieDatabase>().transactionDao
        get<PennieDatabase>().accountDao
        get<PennieDatabase>().categoryDao
        get<PennieDatabase>().budgetDao
    }


}