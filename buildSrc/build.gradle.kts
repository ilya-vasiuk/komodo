plugins {
    `kotlin-dsl`
}

val kotlinVersion = "1.3.50"

repositories {
    jcenter()
    gradlePluginPortal()
    when {
        kotlinVersion.contains("dev") -> maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev/") }
        kotlinVersion.contains("eap") -> maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap/") }
    }
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:0.10.0")
    implementation("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}
