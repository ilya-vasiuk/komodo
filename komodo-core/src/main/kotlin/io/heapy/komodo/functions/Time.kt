package io.heapy.komodo.functions

/**
 * Function to simply measure time spend with some computation.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
suspend fun <T> measureMs(block: suspend () -> T): Pair<Long, T> {
    val start = System.currentTimeMillis()
    val t = block()
    return (System.currentTimeMillis() - start) to t
}
