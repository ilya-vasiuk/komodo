package io.heapy.komodo.di.default

import io.heapy.komodo.di.BindingBuilder
import io.heapy.komodo.di.Provider
import io.heapy.komodo.di.WrappedBindingBuilder
import kotlin.reflect.KClass

/**
 * Komodo implementation of [BindingBuilder].
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoBindingBuilder<T : Any>(
    private val binder: KomodoBinder,
    private val klass: KClass<T>
) : BindingBuilder<T> {
    override fun with(implKlass: KClass<out T>): WrappedBindingBuilder<T> {
        binder.to(klass, implKlass)
        return KomodoWrappedBindingBuilder(binder, klass)
    }

    override fun with(impl: T): WrappedBindingBuilder<T> {
        binder.to(klass, impl)
        return KomodoWrappedBindingBuilder(binder, klass)
    }

    override fun withProvider(provider: KClass<out Provider<T>>): WrappedBindingBuilder<T> {
        binder.toProvider(klass, provider)
        return KomodoWrappedBindingBuilder(binder, klass)
    }
}
