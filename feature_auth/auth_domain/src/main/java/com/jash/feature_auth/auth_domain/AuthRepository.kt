package com.jash.feature_auth.auth_domain

import com.jash.core.domain.AuthInfo
import com.jash.core.domain.util.DataError
import com.jash.core.domain.util.EmptyResult
import com.jash.core.domain.util.Result

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): Result<AuthInfo, DataError.Network>
    suspend fun logout(): EmptyResult<DataError.Network>
    fun getCurrentUserId(): String?
}