package io.heapy.komodo

import kotlin.reflect.KClass

interface Komodo {
    fun args(args: Array<String>): io.heapy.komodo.Komodo
    fun env(env: Map<String, String>): io.heapy.komodo.Komodo
    fun module(module: Module): io.heapy.komodo.Komodo
    suspend fun <R> run(entryPoint: KClass<out io.heapy.komodo.EntryPoint<R>>): R
}
