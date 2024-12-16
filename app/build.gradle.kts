plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    // id("AllurePlugin")
    id("io.qameta.allure") version "2.9.6"

    // /data/data/ru.bellintegrator.android_at_lesson_2/files/allure-results
}

android {
    namespace = "ru.bellintegrator.android_at_lesson_2"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.bellintegrator.android_at_lesson_2"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "io.qameta.allure.android.runners.AllureAndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

allure {
    report {
        version.set("2.19.0")
    }
}

dependencies {
    // Компиляция Kotlin
    // implementation(libs.kotlin.stdlib)

    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    // Библиотека Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Для работы с RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Конвертер Gson для преобразования JSON в объекты Java
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.test.uiautomator:uiautomator-v18:2.2.0-alpha1")
    // to show allure results in android studio
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test:rules:1.0.2")
    androidTestImplementation("com.android.support.test.uiautomator:uiautomator-v18:2.1.3")
    androidTestImplementation("com.android.support:support-annotations:28.0.0")

    // Allure
    androidTestImplementation("io.qameta.allure:allure-kotlin-model:2.4.0")
    androidTestImplementation("io.qameta.allure:allure-kotlin-commons:2.4.0")
    androidTestImplementation("io.qameta.allure:allure-kotlin-junit4:2.4.0")
    androidTestImplementation("io.qameta.allure:allure-kotlin-android:2.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Room components
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
}
