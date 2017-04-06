package by.heap.komodo

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance


fun komodo(builder: Komodo.() -> Unit): Komodo {
    return Komodo().apply {
        builder(this)
        run()
    }
}

class Komodo {
    private val modules = mutableListOf<KClass<out Module>>()
    private val binder = KomodoBinder()

    fun module(module: KClass<out Module>): Komodo {
        this.modules += module
        return this
    }

    fun command(callback: (KomodoBinder) -> Unit) {
        callback(binder)
    }

    fun run() {

        this.modules
            .map { it.createInstance() }
            .onEach { it.configure(binder) }

        println("Started!")
    }
}



fun main(args: Array<String>) {
    val k = komodo {
        module(TestModule1::class)
    }

    k.command ({ it.getBean(DefaultBean2::class).init() })
}

class Bean1 {
    fun init() {
        println("Bean1 Constructed")
    }

    fun foo() {
        println("foo")
    }
}

interface Bean2

class DefaultBean2(val bean1: Bean1) : Bean2 {
    fun init() {
        println("Bean2 Constructed")
        bean1.foo()
    }
}

class TestModule1 : Module {
    override fun configure(binder: Binder) {
        binder.registerBean(Bean1::class)
        binder.registerBean(DefaultBean2::class)
    }

}

// http://picocontainer.com/injection.html
// https://salomonbrys.github.io/Kodein/
// http://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/htmlsingle/#spring-introduction
// http://pholser.github.io/jopt-simple/
// http://www.jcommander.org/
// https://github.com/fusesource/jansi

