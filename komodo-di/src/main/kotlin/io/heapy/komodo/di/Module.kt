package io.heapy.komodo.di

import kotlin.reflect.KClass

/**
 * Interface for defining user modules.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Module {
    /**
     * Wire interfaces with implementations.
     */
    fun assemble(binder: Binder)

    /**
     * Returns set of modules to define on which modules depends current module.
     */
    val requires: Set<KClass<out Module>>
        get() = setOf()
}
