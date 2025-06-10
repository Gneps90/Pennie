plugins {
    alias(libs.plugins.pennie.android.library)
}

android {
    namespace = "com.pennie.feature_settings.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data")) // For SharedPreferences/DataStore access
    implementation(project(":feature_settings:domain"))

    implementation(libs.bundles.koin)

}