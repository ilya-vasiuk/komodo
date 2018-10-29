package io.heapy.komodo.di

import kotlin.reflect.KClass

/**
 * Interface for wiring implementations to interface.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface BindingBuilder<T : Any> {
    fun with(implKlass: KClass<out T>): WrappedBindingBuilder<T>
    fun with(impl: T): WrappedBindingBuilder<T>
    fun withProvider(provider: KClass<out Provider<T>>): WrappedBindingBuilder<T>
}
