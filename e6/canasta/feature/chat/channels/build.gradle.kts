plugins {
    id("nowinandroid.android.feature")
    id("nowinandroid.android.library.compose")
    id("nowinandroid.android.library.jacoco")
}

android {
    namespace = "ven.canasta.feature.chat"
}

dependencies {
    implementation(libs.kotlinx.datetime)

    implementation("io.getstream:stream-chat-android-compose:5.8.2")

    implementation(project(":e6:canasta:core:ui"))
    implementation(project(":e6:canasta:core:designsystem"))
    implementation(project(":e6:canasta:core:domain"))

    implementation(libs.accompanist.flowlayout)
}
