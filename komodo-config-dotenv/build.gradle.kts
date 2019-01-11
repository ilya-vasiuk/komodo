group = "io.heapy.komodo"

apply(from = "$rootDir/publish.gradle")

dependencies {
    implementation(project(":komodo-integration:komodo-logging"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testApi("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
