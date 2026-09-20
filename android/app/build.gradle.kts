import java.io.File

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "de.haushaltsbudget.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "de.haushaltsbudget.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
}

// Die Web-App liegt einzig und allein in index.html im Projekt-Root.
// Vor jedem Build wird sie unverändert in die Android-Assets kopiert,
// damit es nur eine einzige Quelle für den App-Inhalt gibt.
tasks.register<Copy>("prepareWebAssets") {
    val rootIndex = File(rootDir.parentFile, "index.html")
    from(rootIndex)
    into(File(projectDir, "src/main/assets/www"))
    rename { "index.html" }
}

tasks.named("preBuild") {
    dependsOn("prepareWebAssets")
}
