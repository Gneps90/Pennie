plugins {
    alias(libs.plugins.pennie.android.library)
}

android {
    namespace = "com.pennie.core.notification"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.koin)

    implementation(project(":core:domain"))
    implementation(project(":core:presentation:ui"))
    implementation(project(":core:presentation:designsystem"))
}