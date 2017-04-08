package by.heap.komodo

import org.springframework.beans.factory.getBean
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import kotlin.reflect.KClass

/**
 * Binder implementation based on Spring DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class SpringBinder : Binder {
    private val context = AnnotationConfigApplicationContext()

    override fun registerBean(clazz: KClass<*>): Binder {
        context.register(clazz.java)
        return this
    }

    override fun <T : Any> getBean(clazz: KClass<T>): T {
        return context.getBean(clazz)
    }

    override fun <T : Any> getBeans(clazz: KClass<T>): List<T> {
        return context.getBeansOfType(clazz).map { (_, v) -> v }
    }

    override fun start() {
        context.refresh()
    }
}