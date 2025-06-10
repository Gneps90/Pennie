package com.jash.core.notification.di // Adjust package if needed

import org.koin.dsl.module

val notificationModule = module {
    // Add any notification-specific services or managers here
    // For example, the elapsedTime StateFlow was provided from runPresentationModule in Runique.
    // If Pennie needs a similar global timer/state for notifications,
    // it would be defined and provided from an appropriate module.
}