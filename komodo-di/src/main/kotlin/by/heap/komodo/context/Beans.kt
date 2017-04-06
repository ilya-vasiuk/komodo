package by.heap.komodo.context

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
    fun <T : Any> get(kclass: KClass<T>): T
    fun <T : Any> getSet(kclass: KClass<T>): Set<T>
}