import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10"
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.ui)

                implementation(libs.coroutines)
                implementation(libs.koinCore)

                implementation(libs.ktorClientCore)
                implementation(libs.ktorClientLogging)
                implementation(libs.ktorContentNegotiation)
                implementation(libs.ktorSerializationJson)

                implementation(libs.serializationJson)
                implementation(libs.multiplatformSettings)
                implementation(libs.yamlkt)
                implementation(libs.serializationCore)

                implementation(compose.components.resources)

                implementation("dev.icerock.moko:resources-compose:0.23.0")

                implementation(project(":shared"))
                implementation(project(":storage"))
                implementation(project(":auth"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.activityCompose)
                implementation(libs.koinCompose)
                implementation(libs.ktorClientOkhttp)
                implementation(libs.lifecycleViewModel)
                implementation(libs.lifecycleViewModelCompose)



            }
        }
    }
}

android {
    namespace = "app.kariai"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

    defaultConfig {
        applicationId = "app.kariai"
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}

dependencies {
    implementation(libs.foundationAndroid)
    implementation(libs.runtime.android)
    debugImplementation(libs.uiTooling)
}

repositories {
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx/yamlkt")
    mavenCentral()
}