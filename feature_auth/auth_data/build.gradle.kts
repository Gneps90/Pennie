plugins {
    alias(libs.plugins.pennie.android.library)
    alias(libs.plugins.pennie.jvm.ktor)
}

android {
    namespace = "com.pennie.feature_auth.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data")) // For SessionStorage
    implementation(project(":feature_auth:auth_domain"))

    implementation(libs.timber)
    implementation(libs.bundles.koin)
    implementation(libs.firebase.auth)
    implementation(libs.google.firebase.auth.ktx) // Firebase Authentication SDK
    // implementation(libs.play.services.auth) // If using Google Sign-In with Firebase
}