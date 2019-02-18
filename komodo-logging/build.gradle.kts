group = "io.heapy.komodo"

apply(from = "$rootDir/publish.gradle")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("org.slf4j:slf4j-api")
}
