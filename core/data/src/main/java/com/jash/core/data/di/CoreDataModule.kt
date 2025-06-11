package com.jash.core.data.di // Your Pennie package for this module

import com.jash.core.domain.SessionStorage
import com.jash.core.data.auth.EncryptedSessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {

    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}