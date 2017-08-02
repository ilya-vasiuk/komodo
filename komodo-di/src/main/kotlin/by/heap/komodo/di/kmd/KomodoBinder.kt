package by.heap.komodo.di.kmd

import by.heap.komodo.di.Beans
import by.heap.komodo.di.Binder
import by.heap.komodo.di.Provider
import kotlin.reflect.KClass

/**
 * Binder implementation based on Komodo DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoBinder : Binder {
    private val context: Beans = DefaultBeans()

    override fun registerProvider(clazz: KClass<*>, provider: Function<*>): Binder {
        context.registerProvider(clazz, provider)
        return this
    }

    override fun registerProvider(clazz: KClass<*>, provider: KClass<out Provider<*>>): Binder {
        context.registerProvider(clazz, provider)
        return this
    }

    override fun registerBean(clazz: KClass<*>): Binder {
        context.register(clazz)
        return this
    }

    suspend override fun <T : Any> getBean(clazz: KClass<T>): T {
        return context.get(clazz)
    }

    override fun <T : Any> getBeans(clazz: KClass<T>): List<T> {
        return context.getSet(clazz).toList()
    }

    override fun start() {
        println("Komodo Binder start!")
    }
}