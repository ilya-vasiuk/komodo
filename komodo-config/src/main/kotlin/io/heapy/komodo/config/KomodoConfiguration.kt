package io.heapy.komodo.config

import kotlin.reflect.KClass

/**
 * Marker Interface for configuration classes.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KomodoConfiguration {
    suspend fun <T : Any> getConfig(klass: KClass<T>): T?
}
