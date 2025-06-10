plugins {
    alias(libs.plugins.pennie.android.application.compose)
    alias(libs.plugins.google.services)
    alias(libs.plugins.pennie.jvm.ktor)
}

android {
    namespace = "com.jash.pennie"
    defaultConfig {
        applicationId = "com.jash.pennie"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    // future dynamic feature:
    // dynamicFeatures += setOf(":feature_reports:reports_feature")
}

dependencies {
    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)
    implementation(libs.com.google.firebase.firebase.analytics)

    // Koin for DI
    implementation(libs.bundles.koin.compose)

    implementation(libs.androidx.security.crypto.ktx)


    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)


    // Core App libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.core.splashscreen) // For splash screen
    implementation(libs.timber) // Logging

    // Pennie Core Modules
    implementation(project(":core:presentation:designsystem"))
    implementation(project(":core:presentation:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:database"))
    implementation(project(":core:notification"))
    implementation(project(":feature_overview:domain"))
    implementation(project(":feature_overview:data"))
    implementation(project(":feature_overview:presentation"))


    // Pennie Feature Modules (Presentation layers)
    implementation(project(":feature_auth:auth_presentation"))
    implementation(project(":feature_auth:auth_data"))
    implementation(project(":feature_transactions:presentation"))
    implementation(project(":feature_overview:presentation"))
    implementation(project(":feature_reports:presentation"))
    // implementation(project(":feature_reports:reports_feature")) // If dynamic
    implementation(project(":feature_settings:presentation"))
    implementation(libs.security.crypto.ktx)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}