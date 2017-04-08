package by.heap.komodo

import by.heap.komodo.args.Args
import by.heap.komodo.command.CommandExecutor
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance


// kmd?
fun komodo(builder: Komodo.() -> Unit): Komodo {
    return Komodo().apply {
        builder(this)
        run()
    }
}

class Komodo {
    private val modules = mutableListOf<KClass<out Module>>()
    private val binder = SpringBinder()
    private val args = mutableListOf<String>()

    fun module(module: KClass<out Module>): Komodo {
        this.modules += module
        return this
    }

    fun command(callback: (Binder) -> Unit) {
        callback(binder)
    }

    fun args(args: Array<String>): Komodo {
        this.args.addAll(args)
        return this
    }

    fun run() {

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

// http://picocontainer.com/injection.html
// https://salomonbrys.github.io/Kodein/
// http://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/htmlsingle/#spring-introduction
// http://pholser.github.io/jopt-simple/
// http://www.jcommander.org/
// https://github.com/fusesource/jansi

