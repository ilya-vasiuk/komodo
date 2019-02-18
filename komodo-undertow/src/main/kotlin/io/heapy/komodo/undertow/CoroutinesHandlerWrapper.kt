package io.heapy.komodo.undertow


/**
 * Define coroutines wrapper type.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface CoroutinesHandlerWrapper {

    /**
     * Wraps passed handler in another handler.
     *
     * @param handler handler to pass
     */
    suspend fun wrap(handler: CoroutinesHandler): CoroutinesHandler
}
