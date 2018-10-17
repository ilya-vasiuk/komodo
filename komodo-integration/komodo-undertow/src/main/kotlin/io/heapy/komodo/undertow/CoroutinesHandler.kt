package io.heapy.komodo.undertow

import io.undertow.server.HttpHandler
import io.undertow.server.HttpServerExchange
import io.undertow.util.SameThreadExecutor
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Define coroutines handler type.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
typealias CoroutinesHandler = suspend (HttpServerExchange) -> Unit

/**
 * Bridge for using coroutines in undertow handlers.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class CoroutinesHandlerAdapter(
    private val context: CoroutineContext,
    private val handler: CoroutinesHandler
) : HttpHandler {
    override fun handleRequest(exchange: HttpServerExchange) {
        exchange.dispatch(SameThreadExecutor.INSTANCE, Runnable {
            GlobalScope.launch(context = context, start = CoroutineStart.UNDISPATCHED) {
                handler(exchange)
            }
        })
    }
}
