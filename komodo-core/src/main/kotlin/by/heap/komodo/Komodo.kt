package by.heap.komodo

import by.heap.komodo.args.DefaultKmdArgs
import by.heap.komodo.args.KmdArgs
import by.heap.komodo.di.Binder
import by.heap.komodo.di.Module
import by.heap.komodo.di.kmd.KomodoBinder
import kotlinx.coroutines.experimental.runBlocking

fun kmd(builder: suspend Komodo.() -> Unit): Komodo {
    return runBlocking {
        DefaultKomodo().also { instance ->
            println("builder(instance)")
            builder(instance)
            println("instance.run()")
            instance.run()
        }
    }
}

// TODO: Documents
interface Komodo {
    fun module(module: Module): Komodo
    suspend fun command(callback: suspend (Binder) -> Unit)
    fun args(args: Array<String>): Komodo
    suspend fun run()
}

class DefaultKomodo : Komodo {
    private val modules = mutableListOf<Module>()
    private val binder = KomodoBinder()
    private val args = mutableListOf<String>()
    private val commands = mutableListOf<suspend (Binder) -> Unit>()

    override fun module(module: Module): Komodo {
        this.modules += module
        return this
    }

    suspend override fun command(callback: suspend (Binder) -> Unit) {
        commands.add(callback)
    }

    override fun args(args: Array<String>): Komodo {
        this.args.addAll(args)
        binder.registerProvider(KmdArgs::class, { DefaultKmdArgs(listOf(*args)) })
        return this
    }

    suspend override fun run() {
        modules.fold(binder) { b:Binder, module ->
            module(b)
        }
        commands.forEach { it(binder) }
    }
}
