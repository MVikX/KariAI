plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.kotlin.native.cocoapods")
    alias(libs.plugins.mokoResources)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Shared code for NutriAI iOS"
        homepage = "https://your.link"
        version = "1.0.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.koinCore)
                implementation(libs.ktorClientCore)
                implementation(libs.ktorContentNegotiation)
                implementation(libs.ktorClientLogging)
                implementation(libs.ktorSerializationJson)
                implementation(libs.serializationJson)
                implementation(libs.multiplatformSettings)

                implementation(libs.mokoResources)
                implementation(libs.kotlinx.datetime)

                implementation(project(":storage"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientOkhttp)
                implementation(libs.lifecycleViewModel)
                implementation(libs.lifecycleViewModelCompose)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}


android.sourceSets["main"].java.srcDirs("build/generated/moko/androidMain/src")
android.sourceSets["main"].res.srcDirs("build/generated/moko/androidMain/res")


android {
    namespace = "org.example.nutriai.shared"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}


repositories {
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenCentral()
    maven("https://jitpack.io")
}



multiplatformResources {
    multiplatformResourcesPackage = "org.example.nutriai.shared"
}