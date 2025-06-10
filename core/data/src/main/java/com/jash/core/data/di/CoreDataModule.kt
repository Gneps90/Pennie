package com.jash.core.data.di // Your Pennie package for this module

import com.jash.core.domain.SessionStorage
import com.jash.core.data.auth.EncryptedSessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    // Provides the single, encrypted implementation of SessionStorage
    // This is still needed to store the user's login session on the device.
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}