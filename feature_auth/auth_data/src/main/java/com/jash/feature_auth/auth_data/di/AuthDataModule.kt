package com.jash.feature_auth.auth_data.di

import com.google.firebase.auth.FirebaseAuth
import com.jash.feature_auth.auth_domain.AuthRepository
import com.jash.feature_auth.auth_domain.PatternValidator
import com.jash.feature_auth.auth_data.AuthRepositoryImpl
import com.jash.feature_auth.auth_data.EmailPatternValidator
import com.jash.feature_auth.auth_domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)


    single<FirebaseAuth> {
        FirebaseAuth.getInstance()
    }

    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}