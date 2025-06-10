package com.jash.feature_auth.auth_presentation.di

import com.jash.feature_auth.auth_presentation.login.LoginViewModel
import com.jash.feature_auth.auth_presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}