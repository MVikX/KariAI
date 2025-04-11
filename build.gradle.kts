plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10" apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}