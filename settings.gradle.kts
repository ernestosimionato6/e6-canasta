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
rootProject.name = "nowinandroid"
include(":e6:canasta:app:grocery-app")
include(":app")
include(":nia-app")
include(":app-nia-catalog")
include(":benchmarks")
include(":core:common")
include(":core:data")
include(":core:data-test")
include(":core:database")
include(":core:datastore")
include(":core:datastore-test")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":core:testing")
include(":feature:foryou")
include(":feature:interests")
include(":feature:bookmarks")
include(":feature:topic")
include(":feature:settings")
include(":lint")
include(":sync:work")
include(":sync:sync-test")
include(":ui-test-hilt-manifest")