package io.heapy.komodo.undertow

import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.SameThreadExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Bridge for using coroutines in undertow handlers.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class CoroutinesHandlerAdapter(
    private val context: CoroutineContext = Dispatchers.Default,
    private val handler: CoroutinesHandler
) : HttpHandler {
    override fun handleRequest(exchange: HttpServerExchange) {
        exchange.dispatch(SameThreadExecutor.INSTANCE, Runnable {
            GlobalScope.launch(context = context) {
                handler.handleRequest(exchange)
            }
        })
    }
}
