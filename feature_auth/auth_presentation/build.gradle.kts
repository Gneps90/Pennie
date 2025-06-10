plugins {
    alias(libs.plugins.pennie.android.feature.ui)
    alias(libs.plugins.jetbrainsKotlinAndroid)}


android {
    namespace = "com.pennie.feature_auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.featureAuth.authDomain)
    

}