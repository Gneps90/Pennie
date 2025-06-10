package com.jash.feature_overview.domain.di

import com.jash.feature_overview.domain.GetOverviewData
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val overviewDomainModule = module {
    factoryOf(::GetOverviewData)
}