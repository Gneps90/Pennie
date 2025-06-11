plugins {
    alias(libs.plugins.pennie.android.feature.ui)
}

android {
    namespace = "com.pennie.feature_overview.presentation"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":feature_overview:domain"))
    implementation(projects.core.presentation.designsystem)
}