plugins {
    alias(libs.plugins.pennie.android.library.compose)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.pennie.core.presentation.designsystem"
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.material3)


}