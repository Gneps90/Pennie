package com.jash.feature_overview.data.di

import com.jash.feature_overview.data.OverviewRepositoryImpl
import com.jash.feature_overview.domain.OverviewRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val overviewDataModule = module {
    singleOf(::OverviewRepositoryImpl).bind<OverviewRepository>()
}