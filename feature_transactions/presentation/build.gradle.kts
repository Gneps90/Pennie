plugins {
    alias(libs.plugins.pennie.android.feature.ui)
}

android {
    namespace = "com.pennie.feature_transactions.presentation"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":feature_transactions:domain"))
}