plugins {
    alias(libs.plugins.pennie.jvm.library)
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)


    implementation(project(":core:domain"))
}