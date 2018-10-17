dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")

    compile(project(":komodo-light"))
    compile("org.slf4j:slf4j-api")

    testCompile("io.mockk:mockk")
    testCompile("org.junit.jupiter:junit-jupiter-engine")
}


