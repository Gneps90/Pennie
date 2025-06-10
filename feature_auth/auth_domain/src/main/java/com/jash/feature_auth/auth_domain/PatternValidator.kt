package com.jash.feature_auth.auth_domain

interface PatternValidator {
    fun matches(value: String): Boolean
}