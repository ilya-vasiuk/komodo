package io.heapy.komodo.di

/**
 * We need Provider interface until issue with reflection for lambda parameters not resolved.
 * https://youtrack.jetbrains.com/issue/KT-9062
 * Than we can use lambdas instead.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Provider<out T> {
    suspend fun getInstance(): T
}
