package by.heap.komodo

import by.heap.komodo.args.DefaultKmdArgs
import by.heap.komodo.args.KmdArgs
import kotlinx.coroutines.experimental.runBlocking
import kotlin.reflect.KClass

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
    fun module(module: KClass<out Module>): Komodo
    suspend fun command(callback: suspend (Binder) -> Unit)
    fun args(args: Array<String>): Komodo
    fun run()
}

class DefaultKomodo : Komodo {
    private val modules = mutableListOf<KClass<out Module>>()
    private val binder = KomodoBinder()
    private val args = mutableListOf<String>()

    override fun module(module: KClass<out Module>): Komodo {
        this.modules += module
        return this
    }

    suspend override fun command(callback: suspend (Binder) -> Unit) {
        callback(binder)
    }

    override fun args(args: Array<String>): Komodo {
        this.args.addAll(args)
        binder.registerProvider(KmdArgs::class, { DefaultKmdArgs(listOf(*args)) })
        return this
    }

    override fun run() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
