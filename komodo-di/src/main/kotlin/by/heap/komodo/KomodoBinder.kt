package by.heap.komodo

import kotlin.reflect.KClass

/**
 * Binder implementation based on Komodo DI
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoBinder : Binder {
    override fun registerBean(clazz: KClass<*>): Binder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any> getBean(clazz: KClass<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any> getBeans(clazz: KClass<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}