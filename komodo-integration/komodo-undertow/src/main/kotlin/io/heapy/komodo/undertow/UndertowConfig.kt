package io.heapy.komodo.undertow

import java.nio.file.Path

/**
 * Basic Configuration of Undertow.
 * Used for creating default instance of undertow.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
data class UndertowConfig(
    val httpListeners: List<HttpListenerConfig> = listOf(HttpListenerConfig(8080, "0.0.0.0")),
    val httpsListeners: List<HttpsListenerConfig> = listOf(),
    val bufferSize: Int?,
    val ioThreads: Int?,
    val workerThreads: Int?,
    val directBuffers: Boolean?,
    val staticFiles: List<Path> = listOf()
)

data class HttpListenerConfig(
    val port: Int,
    val host: String
)

data class HttpsListenerConfig(
    val port: Int,
    val host: String
)
