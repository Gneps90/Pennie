plugins {
    alias(libs.plugins.pennie.android.library)
}

android {
    namespace = "com.pennie.feature_overview.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database")) // To access DAOs for aggregating data
    implementation(project(":feature_overview:domain"))

    implementation(libs.bundles.koin)
}