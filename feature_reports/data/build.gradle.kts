plugins {
    alias(libs.plugins.pennie.android.library)
    alias(libs.plugins.pennie.android.room)
}

android {
    namespace = "com.pennie.feature_reports.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database")) // Access to DAOs (TransactionDao, etc.)
    implementation(project(":feature_reports:domain"))

    implementation(libs.bundles.koin)

}