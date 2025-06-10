package com.jash.feature_overview.presentation.di

import com.jash.feature_overview.presentation.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val overviewViewModelModule = module {
    viewModelOf(::OverviewViewModel)
}