package io.heapy.komodo.di

import kotlin.reflect.KClass

/**
 * Binder interface.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Binder {
    fun <T : Any> wire(klass: KClass<T>): BindingBuilder<T>
}
