import com.google.samples.apps.nowinandroid.FlavorDimension
import com.google.samples.apps.nowinandroid.NiaFlavor

plugins {
    id("nowinandroid.android.application")
    id("nowinandroid.android.application.compose")
}

android {
    defaultConfig {
        applicationId = "ven.canasta.apps.grocery.mock"
        versionCode = 1
        versionName = "0.0.1"
        missingDimensionStrategy(FlavorDimension.contentType.name, NiaFlavor.demo.name)
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    namespace = "ven.canasta.apps.grocery"

    buildTypes {
        val release by getting {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(project(":e6:canasta:core:ui"))
    implementation(project(":e6:canasta:core:designsystem"))

    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.flowlayout)
}
