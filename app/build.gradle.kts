plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.remziakgoz.programmingjokes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.remziakgoz.programmingjokes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

val ktorVersion = "2.3.0"

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.crashlytics.buildtools)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Ktor Dependencies
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation ("io.ktor:ktor-client-cio:$ktorVersion")  // CIO Engine

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("androidx.work:work-runtime-ktx:2.8.1") // En son sürüm olup olmadığını kontrol edin


    dependencies {
        // Retrofit Core
        implementation("com.squareup.retrofit2:retrofit:2.9.0")

        // Gson Converter (JSON verilerini sınıflara dönüştürmek için)
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Kotlinx Serialization Converter (Kotlinx Serialization ile kullanmak için)
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

        // OkHttp Core (Retrofit için gerekli altyapı)
        implementation("com.squareup.okhttp3:okhttp:4.11.0")

        // OkHttp Logging Interceptor (HTTP isteklerini loglamak için)
        implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

        // Coroutines Support (Opsiyonel, Retrofit'i Coroutines ile kullanıyorsan)
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    }
}