group = "io.heapy.komodo.integration"

apply(from = "$rootDir/publish.gradle")

dependencies {
    implementation(project(":komodo-logging"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.junit.platform:junit-platform-engine")

    testApi("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
