package io.heapy.komodo.config

import kotlin.reflect.KClass

/**
 * Marker Interface for configuration classes.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KomodoConfiguration {
    suspend fun <T : Any> getConfig(klass: KClass<T>): T?
}
