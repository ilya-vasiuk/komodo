package by.heap.komodo.di

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Provider<out T> {
    suspend fun getInstance(): T
}