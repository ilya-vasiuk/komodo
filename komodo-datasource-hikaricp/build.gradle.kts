group = "io.heapy.komodo.integration"

apply(from = "$rootDir/publish.gradle")

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compile(project(":komodo-datasource"))
    compile("com.zaxxer:HikariCP")

    testCompile("org.slf4j:slf4j-simple")
    testCompile("io.mockk:mockk")
    testApi("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
