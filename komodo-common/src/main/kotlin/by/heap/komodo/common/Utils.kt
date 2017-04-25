package by.heap.komodo.common

inline fun <T> measureMs(block: () -> T): Pair<Long, T> {
    val start = System.currentTimeMillis()
    val t = block()
    return (System.currentTimeMillis() - start) to t
}