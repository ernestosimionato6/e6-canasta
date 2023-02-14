@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation("androidx.room:room-common:2.4.3")
}