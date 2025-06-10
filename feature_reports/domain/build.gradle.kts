plugins {
    alias(libs.plugins.pennie.jvm.library)
}

dependencies {
    implementation(project(":core:domain"))
    // kotlinx.coroutines might be added by the convention plugin
}