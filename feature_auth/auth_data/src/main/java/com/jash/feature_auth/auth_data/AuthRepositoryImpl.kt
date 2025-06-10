package com.jash.feature_auth.auth_data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.jash.core.domain.AuthInfo
import com.jash.core.domain.SessionStorage
import com.jash.core.domain.util.DataError
import com.jash.core.domain.util.EmptyResult
import com.jash.core.domain.util.Result
import com.jash.feature_auth.auth_domain.AuthRepository
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class AuthRepositoryImpl(
    private val auth: FirebaseAuth, // Will be injected by Koin later
    private val sessionStorage: SessionStorage // Will be injected by Koin later
) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            Result.Success(Unit)
        } catch (e: FirebaseAuthUserCollisionException) {
            Result.Error(DataError.Network.CONFLICT) // Email already exists
        } catch (e: Exception) {
            Timber.e(e, "Firebase registration error")
            Result.Error(DataError.Network.UNKNOWN)
        }
    }

    override suspend fun login(email: String, password: String): Result<AuthInfo, DataError.Network> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = result.user
            if (firebaseUser == null) {
                Result.Error(DataError.Network.UNAUTHORIZED)
            } else {
                val idTokenResult = firebaseUser.getIdToken(true).await() // Force refresh
                val idToken = idTokenResult.token ?: ""

                val authInfo = AuthInfo(
                    accessToken = idToken,
                    userId = firebaseUser.uid
                )
                sessionStorage.set(authInfo)
                Result.Success(authInfo)
            }
        } catch (e: FirebaseAuthInvalidUserException) {
            Result.Error(DataError.Network.UNAUTHORIZED) // User not found
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Result.Error(DataError.Network.UNAUTHORIZED) // Wrong password
        } catch (e: Exception) {
            Timber.e(e, "Firebase login error")
            Result.Error(DataError.Network.UNKNOWN)
        }
    }

    override suspend fun logout(): EmptyResult<DataError.Network> {
        return try {
            auth.signOut()
            sessionStorage.set(null)
            Result.Success(Unit)
        } catch (e: Exception) {
            Timber.e(e, "Firebase logout error")
            Result.Error(DataError.Network.UNKNOWN)
        }
    }

    override fun getCurrentUserId(): String? {
        return auth.currentUser?.uid
    }
}