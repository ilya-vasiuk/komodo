package io.heapy.komodo.di

import kotlin.reflect.KClass

/**
 * Binder interface.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Binder {
    fun <T : Any> wire(klass: KClass<T>): BindingBuilder<T>
}
