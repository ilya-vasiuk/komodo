package by.heap.komodo.context

import by.heap.komodo.Provider
import kotlin.reflect.KClass

/**
 * Komodo's DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Beans {
    fun start()
    fun register(kclass: KClass<*>): Beans
    fun registerProvider(kclass: KClass<*>, provider: Function<*>): Beans
    fun registerProvider(kclass: KClass<*>, provider: KClass<out Provider<*>>): Beans
    suspend fun <T : Any> get(kclass: KClass<T>): T
    fun <T : Any> getSet(kclass: KClass<T>): Set<T>
}