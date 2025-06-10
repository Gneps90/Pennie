plugins {
    alias(libs.plugins.pennie.jvm.library)
}

dependencies {
    implementation(project(":core:domain"))
}