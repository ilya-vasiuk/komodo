package io.heapy.komodo

import kotlin.reflect.KClass

/**
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultKomodo : io.heapy.komodo.Komodo {
    private val modules = mutableListOf<Module>()
    private val args = mutableListOf<String>()
    private val env = mutableMapOf<String, String>()

    override fun module(module: Module): io.heapy.komodo.Komodo {
        modules += module
        return this
    }

    override fun args(args: Array<String>): io.heapy.komodo.Komodo {
        this.args += args
        return this
    }

    override fun env(env: Map<String, String>): io.heapy.komodo.Komodo {
        this.env += env
        return this
    }

    override suspend fun <R> run(entryPoint: KClass<out EntryPoint<R>>): R {
        return entryPoint.objectInstance!!.run()
    }
}
