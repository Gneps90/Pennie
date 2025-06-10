plugins {
    alias(libs.plugins.pennie.android.library)
    alias(libs.plugins.pennie.jvm.ktor)
}

android {
    namespace = "com.pennie.core.data"
}

dependencies {
    implementation(libs.timber) // For logging, if using it
    implementation(libs.bundles.koin) // For Koin dependency injection

    implementation(project(":core:domain"))
    implementation(project(":core:database"))

    implementation(libs.firebase.auth)
    implementation(platform(libs.firebase.bom))

}