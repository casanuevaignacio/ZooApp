// TOP-LEVEL build file
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Usamos la versión 2.5.3 para que coincida con tus librerías de navegación
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}