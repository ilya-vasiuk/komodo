group = "io.heapy.komodo"

apply(from = "$rootDir/publish.gradle")

dependencies {
    // kotlin & coroutines
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")

    // undertow
    api("io.undertow:undertow-core")
}
