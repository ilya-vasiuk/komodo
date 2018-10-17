package io.heapy.komodo.di.default

import io.heapy.komodo.di.Module
import io.heapy.komodo.di.Provider
import io.heapy.komodo.di.WrappedBindingBuilder
import kotlin.reflect.KClass

/**
 * Komodo implementation of [WrappedBindingBuilder].
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoWrappedBindingBuilder<T : Any>(
    private val binder: KomodoBinder,
    private val key: KClass<T>
) : WrappedBindingBuilder<T> {
    override fun override(moduleKlass: KClass<out Module>) {
        binder.override(key, moduleKlass)
    }

    override fun decorate(klass: KClass<out T>): WrappedBindingBuilder<T> {
        binder.decorate(key, klass)
        return this
    }

    override fun decorate(impl: T): WrappedBindingBuilder<T> {
        binder.decorate(key, impl)
        return this
    }

    override fun decorateWithProvider(provider: KClass<out Provider<T>>): WrappedBindingBuilder<T> {
        binder.decorateWithProvider(key, provider)
        return this
    }
}
