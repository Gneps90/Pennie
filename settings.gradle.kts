pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Pennie"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// Core Modules
include(":app")

include(":core:domain")


include(":core:presentation:designsystem")
include(":core:presentation:ui")



include(":core:data")
include(":core:database")
include(":core:notification")
include(":feature_auth:auth_data")
include(":feature_auth:auth_domain")
include(":feature_auth:auth_presentation")
include(":feature_transactions:data")
include(":feature_transactions:domain")
include(":feature_transactions:presentation")
include(":feature_overview:data")
include(":feature_overview:domain")
include(":feature_overview:presentation")
include(":feature_reports:data")
include(":feature_reports:domain")
include(":feature_reports:presentation")
include(":feature_reports:reports")
include(":feature_settings:data")
include(":feature_settings:domain")
include(":feature_settings:presentation")
