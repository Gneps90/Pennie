plugins {
    alias(libs.plugins.pennie.android.library)
}

android {
    namespace = "com.pennie.feature_overview.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
    implementation(project(":feature_overview:domain"))

    implementation(libs.bundles.koin)
}