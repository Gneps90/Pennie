package com.jash.feature_overview.presentation

sealed interface OverviewEvent {
    data object OnLogout : OverviewEvent
}