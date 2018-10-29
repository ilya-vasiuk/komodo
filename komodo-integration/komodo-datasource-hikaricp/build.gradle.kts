group = "io.heapy.komodo.integration"

apply(from = "$rootDir/publish.gradle")

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compile(project(":komodo-core-timeunits"))
    compile(project(":komodo-core-beans"))
    compile(project(":komodo-integration:komodo-datasource"))
    compile("com.zaxxer:HikariCP")

    testCompile("org.slf4j:slf4j-simple")
    testCompile("io.mockk:mockk")
    testCompile("org.junit.jupiter:junit-jupiter-engine")
}
