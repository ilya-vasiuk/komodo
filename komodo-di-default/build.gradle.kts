dependencies {
    compile(project(":komodo-di"))

    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")

    testCompile("io.mockk:mockk")
    testCompile("org.junit.jupiter:junit-jupiter-engine")
}
