plugins {
    alias(libs.plugins.pennie.jvm.library) // Convention plugin from build-logic


}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}