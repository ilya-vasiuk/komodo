package io.heapy.komodo.di

/**
 * We need Provider interface until issue with reflection for lambda parameters not resolved.
 * https://youtrack.jetbrains.com/issue/KT-9062
 * Than we can use lambdas instead.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Provider<out T> {
    suspend fun getInstance(): T
}
