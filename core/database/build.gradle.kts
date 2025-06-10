plugins {
    alias(libs.plugins.pennie.android.library)
    alias(libs.plugins.pennie.android.room) // Convention plugin for Room setup
}

android {
    namespace = "com.pennie.core.database"
}

dependencies {
    implementation(libs.org.mongodb.bson) // If using BSON for ObjectIds
    implementation(libs.bundles.koin) // For Koin DI

    implementation(project(":core:domain"))

}