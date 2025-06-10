package com.jash.feature_auth.auth_data

import android.util.Patterns
import com.jash.feature_auth.auth_domain.PatternValidator

object EmailPatternValidator : PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}