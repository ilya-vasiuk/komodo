package by.heap.komodo

import kotlin.reflect.KClass

/**
 * Binder interface.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Binder {
    fun registerBean(clazz: KClass<*>): Binder
    fun <T: Any> getBean(clazz: KClass<T>): T
}