group = "io.heapy.komodo"

apply(from = "$rootDir/publish.gradle")

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile(project(":komodo-core"))
}

