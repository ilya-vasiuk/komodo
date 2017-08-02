package by.heap.komodo.di

import kotlin.reflect.KClass

/**
 * Binder interface.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Binder {
    fun registerBean(clazz: KClass<*>): Binder
    fun registerProvider(clazz: KClass<*>, provider: KClass<out Provider<*>>): Binder
    suspend fun <T: Any> getBean(clazz: KClass<T>): T
    fun <T: Any> getBeans(clazz: KClass<T>): List<T>
    fun start()
    fun registerProvider(clazz: KClass<*>, provider: Function<*>): Binder
}