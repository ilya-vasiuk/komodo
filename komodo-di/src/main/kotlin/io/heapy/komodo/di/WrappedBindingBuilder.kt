package io.heapy.komodo.di

import kotlin.reflect.KClass

/**
 * Interface for decorating one impl with another.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface WrappedBindingBuilder<T : Any> {
    fun override(moduleKlass: KClass<out Module>)
    fun decorate(klass: KClass<out T>): WrappedBindingBuilder<T>
    fun decorate(impl: T): WrappedBindingBuilder<T>
    fun decorateWithProvider(provider: KClass<out Provider<T>>): WrappedBindingBuilder<T>
}

