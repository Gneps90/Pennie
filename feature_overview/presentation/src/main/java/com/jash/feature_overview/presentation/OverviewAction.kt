package com.jash.feature_overview.presentation

sealed interface OverviewAction {

    data object OnStartClick: OverviewAction
    data object OnLogoutClick: OverviewAction
    data object OnAnalyticsClick: OverviewAction

}