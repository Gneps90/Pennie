package com.jash.pennie

data class MainState(
    val isLoggedIn: Boolean = false,
    val isCheckingAuth: Boolean = true // Show splash screen while checking
)