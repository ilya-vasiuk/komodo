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
    "komodo-env",
    "komodo-bom",
    "komodo-completability",
    "komodo-config",
    "komodo-config-kotlin",
    "komodo-config-dotenv",
    "komodo-console",
    "komodo-core",
    "komodo-core-coroutines",
    "komodo-core-concurrent",
    "komodo-core-beans",
    "komodo-di",
    "komodo-di-default",
    "komodo-datasource",
    "komodo-datasource-hikaricp",
    "komodo-http",
    "komodo-jooq",
    "komodo-ktor-client",
    "komodo-ktor-server",
    "komodo-logging",
    "komodo-logging-logback",
    "komodo-metrics",
    "komodo-metrics-micrometer",
    "komodo-r2dbc",
    "komodo-undertow",
    "komodo-junit5-enterprise",
    "komodo-junit5-kirk",
    "komodo-light",
    "komodo-samples",
    "komodo-samples:sample-komodo",
    "komodo-samples:sample-komodo-light",
    "komodo-scripting"
)
