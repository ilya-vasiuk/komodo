package by.heap.komodo

import by.heap.komodo.args.Args
import by.heap.komodo.args.DefaultKmdArgs
import by.heap.komodo.args.KmdArgs
import by.heap.komodo.command.CommandExecutor
import kotlinx.coroutines.experimental.runBlocking
import java.util.function.Supplier
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

fun komodo(builder: suspend Komodo.() -> Unit): Komodo {
    return runBlocking {
        SpringKomodo().also { instance ->
            println("builder(instance)")
            builder(instance)
            println("instance.run()")
//            instance.run()
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

class SpringKomodo : Komodo {
    private val modules = mutableListOf<KClass<out Module>>()
    private val binder = SpringBinder()
    private val args = mutableListOf<String>()

    override fun module(module: KClass<out Module>): Komodo {
        this.modules += module
        return this
    }

    override suspend fun command(callback: suspend (Binder) -> Unit) {
        callback(binder)
    }

    override fun args(args: Array<String>): Komodo {
        this.args.addAll(args)
        binder.getContext().registerBean(KmdArgs::class.java, Supplier<KmdArgs> { DefaultKmdArgs(this.args) })
        return this
    }

    override fun run() {
        this.modules
            .map { it.createInstance() }
            .onEach { it.configure(binder) }

        binder.start()

        val args = binder.getBean(Args::class)
        val commandExecutor = binder.getBean(CommandExecutor::class)
        commandExecutor.execute(args.getCommand(this.args))

        println("Started!")
    }
}
