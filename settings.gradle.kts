pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap/") }
    }
}

rootProject.name = "komodo"

include("komodo")
include("komodo-args")
include("komodo-bom")
include("komodo-config")
include("komodo-console")
include("komodo-core")
include("komodo-di")
include("komodo-di-default")
include("komodo-light")
include("komodo-samples")
include("komodo-samples:sample-komodo")
include("komodo-samples:sample-komodo-light")
include("komodo-scripting")
include("komodo-integration")
include("komodo-integration:komodo-http")
include("komodo-integration:komodo-jooq")
include("komodo-integration:komodo-slf4j")
include("komodo-integration:komodo-ktor-server")
include("komodo-integration:komodo-ktor-client")
include("komodo-integration:komodo-undertow")
