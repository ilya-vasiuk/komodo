package by.heap.komodo.di.kmd

import kotlin.reflect.KClass
import kotlin.reflect.KFunction

/**
 * Represents bean in context.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
data class BeanDefinition<T : Any>(val klass: KClass<T>, val constructor: KFunction<*>)