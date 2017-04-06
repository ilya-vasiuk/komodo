package by.heap.komodo

import by.heap.komodo.context.DefaultBeans
import kotlin.reflect.KClass

/**
 * Binder implementation based on Spring DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoBinder : Binder {
    private val context = DefaultBeans()

    override fun registerBean(clazz: KClass<*>): Binder {
        context.register(clazz)
        return this
    }

    override fun <T : Any> getBean(clazz: KClass<T>): T {
        return context.get(clazz)
    }
}