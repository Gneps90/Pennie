plugins {
    alias(libs.plugins.pennie.android.feature.ui)
}

android {
    namespace = "com.pennie.feature_reports.presentation"
}

dependencies {
    implementation(project(":feature_reports:domain"))
    // Core UI/Designsystem dependencies are handled by the convention plugin
}