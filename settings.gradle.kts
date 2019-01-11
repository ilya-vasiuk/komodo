pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap/") }
    }
}

rootProject.name = "komodo"

include(
    "komodo",
    "komodo-args",
    "komodo-bom",
    "komodo-config",
    "komodo-config-dotenv",
    "komodo-console",
    "komodo-common",
    "komodo-core",
    "komodo-core-timeunits",
    "komodo-core-coroutines",
    "komodo-core-concurrent",
    "komodo-core-beans",
    "komodo-di",
    "komodo-di-default",
    "komodo-integration:komodo-datasource",
    "komodo-integration:komodo-datasource-hikaricp",
    "komodo-integration:komodo-http",
    "komodo-integration:komodo-jooq",
    "komodo-integration:komodo-metrics",
    "komodo-integration:komodo-metrics-micrometer",
    "komodo-integration:komodo-logging",
    "komodo-integration:komodo-logging-logback",
    "komodo-integration:komodo-ktor-server",
    "komodo-integration:komodo-r2dbc",
    "komodo-integration:komodo-undertow",
    "komodo-integration:komodo-ktor-client",
    "komodo-junit5-coroutines-engine",
    "komodo-light",
    "komodo-samples",
    "komodo-samples:sample-komodo",
    "komodo-samples:sample-komodo-light",
    "komodo-scripting"
)
