pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap/") }
    }
}

// emulate behaviour of gradle 5
enableFeaturePreview("STABLE_PUBLISHING")

rootProject.name = "komodo"

include(
    "komodo",
    "komodo-args",
    "komodo-bom",
    "komodo-config",
    "komodo-console",
    "komodo-core",
    "komodo-di",
    "komodo-di-default",
    "komodo-light",
    "komodo-samples",
    "komodo-samples:sample-komodo",
    "komodo-samples:sample-komodo-light",
    "komodo-scripting",
    "komodo-integration",
    "komodo-integration:komodo-http",
    "komodo-integration:komodo-jooq",
    "komodo-integration:komodo-slf4j",
    "komodo-integration:komodo-ktor-server",
    "komodo-integration:komodo-ktor-client",
    "komodo-integration:komodo-undertow"
)
