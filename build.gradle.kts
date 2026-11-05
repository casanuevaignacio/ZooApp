// TOP-LEVEL build file
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Usamos la versión 2.5.3 para que coincida con tus librerías de navegación
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.9.6")
    }
}

plugins {
    id("com.android.application") version "9.4.1" apply false
    id("org.jetbrains.kotlin.android") version "2.2.10" apply false
    id("com.google.devtools.ksp") version "2.3.6" apply false
    alias(libs.plugins.kotlin.compose) apply false
}