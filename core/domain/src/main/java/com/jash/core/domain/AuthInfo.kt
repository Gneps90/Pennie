package com.jash.core.domain

data class AuthInfo(
    val accessToken: String, // For Firebase, this will typically be the ID Token
    val userId: String
)