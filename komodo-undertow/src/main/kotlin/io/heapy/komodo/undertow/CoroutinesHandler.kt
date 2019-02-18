package io.heapy.komodo.undertow

import io.undertow.server.HttpServerExchange

/**
 * Define coroutines handler type.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface CoroutinesHandler {

    /**
     * Handle the request.
     *
     * @param exchange the HTTP request/response exchange
     */
    suspend fun handleRequest(exchange: HttpServerExchange)
}
