plugins {
    id("nowinandroid.android.feature")
    id("nowinandroid.android.library.compose")
    id("nowinandroid.android.library.jacoco")
}

android {
    namespace = "ven.canasta.feature.grocery"
}

dependencies {
    implementation(libs.kotlinx.datetime)

    implementation(project(":e6:canasta:core:ui"))
    implementation(project(":e6:canasta:core:designsystem"))
    implementation(project(":e6:canasta:core:domain"))

    implementation(libs.accompanist.flowlayout)
}
