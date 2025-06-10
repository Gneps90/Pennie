plugins {
    alias(libs.plugins.pennie.android.library)
}

android {
    namespace = "com.pennie.feature_transactions.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database")) // For TransactionDao
    implementation(project(":feature_transactions:domain"))

    implementation(libs.bundles.koin)
}