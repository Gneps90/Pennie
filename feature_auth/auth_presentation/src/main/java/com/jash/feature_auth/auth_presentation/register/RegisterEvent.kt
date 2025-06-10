package com.jash.feature_auth.auth_presentation.register

import com.jash.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent

    data class Error(val error: UiText): RegisterEvent
}