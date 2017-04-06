package by.heap.komodo

import org.springframework.beans.factory.getBean
import org.springframework.context.support.GenericApplicationContext
import kotlin.reflect.KClass

/**
 * Binder implementation based on Spring DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class SpringBinder : Binder {
    private val context = GenericApplicationContext()

    override fun registerBean(clazz: KClass<*>): Binder {
        context.registerBean(clazz.java)
        return this
    }

    override fun <T : Any> getBean(clazz: KClass<T>): T {
        return context.getBean(clazz)
    }

    fun start() {
        context.refresh()
    }
}