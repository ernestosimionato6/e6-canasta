@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("nowinandroid.android.library")
    id("nowinandroid.android.library.jacoco")
    id("nowinandroid.android.hilt")
    id("kotlinx-serialization")
    alias(libs.plugins.ksp)
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

        testInstrumentationRunner = "ven.movies.core.testing.MoviesTestRunner"
    }
    namespace = "ven.movies.core.database"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    implementation(project(":e6:movies:core:domain"))
    implementation(project(":e6:movies:core:model"))



    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation("androidx.test:core-ktx:1.5.0")
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(project(":core:testing"))

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    testImplementation("io.mockk:mockk:1.12.7")
    testImplementation("org.mockito:mockito-core:4.8.0")
    testImplementation("org.mockito:mockito-inline:4.0.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    //androidTestImplementation("androidx.test.espresso:expresso-core:3.4.0")
    // androidTestImplementation("androidx.compose.ui:ui-tooling:")

}