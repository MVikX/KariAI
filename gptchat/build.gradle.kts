plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.kotlin.native.cocoapods")
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "ChatGPT integration for KariAI"
        homepage = "https://your.link"
        version = "1.0.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "gptchat"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.ktorClientCore)
                implementation(libs.ktorContentNegotiation)
                implementation(libs.ktorClientLogging)
                implementation(libs.ktorSerializationJson)
                implementation(libs.serializationJson)
                implementation(libs.kotlinx.datetime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientOkhttp)
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
            dependencies {
                implementation(libs.ktorClientDarwin)
            }
        }
    }
}

android {
    namespace = "app.kariai.gptchat"
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