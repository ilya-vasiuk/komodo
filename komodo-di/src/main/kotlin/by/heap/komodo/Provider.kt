package by.heap.komodo

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Provider<out T> {
    suspend fun getInstance(): T
}