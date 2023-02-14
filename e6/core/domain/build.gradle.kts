plugins {
    id("nowinandroid.android.library")
    id("nowinandroid.android.library.jacoco")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.google.samples.apps.nowinandroid.core.domain"
}

dependencies {

    implementation(project(":core:data"))
   implementation(project(":core:model"))

    implementation(project(":e6:core:model"))

    testImplementation(project(":core:testing"))

    //Mockk
    testImplementation("io.mockk:mockk:1.12.7")

//Mockito
    testImplementation("org.mockito:mockito-core:4.8.0")
    testImplementation("org.mockito:mockito-inline:4.0.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}