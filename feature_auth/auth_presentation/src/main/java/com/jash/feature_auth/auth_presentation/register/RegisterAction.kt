package com.jash.feature_auth.auth_presentation.register

sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick: RegisterAction

    data object OnLoginClick: RegisterAction

    data object OnRegisterClick: RegisterAction
}