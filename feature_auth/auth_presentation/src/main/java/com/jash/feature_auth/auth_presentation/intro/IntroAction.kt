package com.jash.feature_auth.auth_presentation.intro

sealed interface IntroAction {

    data object OnSignInClick: IntroAction

    data object OnSignUpClick: IntroAction
}