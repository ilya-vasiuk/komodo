package by.heap.komodo.samples

import by.heap.komodo.Binder
import by.heap.komodo.Module
import by.heap.komodo.args.DefaultArgs
import by.heap.komodo.command.Command
import by.heap.komodo.command.CommandArguments
import by.heap.komodo.command.CommandResult
import by.heap.komodo.command.DefaultCommandExecutor
import by.heap.komodo.command.SuccessResult
import by.heap.komodo.komodo

fun main(args: Array<String>) {
    val k = komodo {
        module(TestModule1::class)
        args(args)
    }

    k.command({
        it.getBeans(Bean2::class).forEach { it.init() }
    })
}

class Bean1 {
    fun init() {
        println("Bean1 Constructed")
    }

    fun foo() {
        println("foo")
    }
}

interface Bean2 {
    fun init()
}

class DefaultBean2(val bean1: Bean1) : Bean2 {
    override fun init() {
        println("Default Bean2 Constructed")
        bean1.foo()
    }
}

class TestBean2(val bean1: Bean1) : Bean2 {
    override fun init() {
        println("Test Bean2 Constructed")
        bean1.foo()
    }
}

class CustomBean2(val bean1: Bean1) : Bean2 {
    override fun init() {
        println("Custom Bean2 Constructed")
        bean1.foo()
    }
}

class TestModule1 : Module {
    override fun configure(binder: Binder) {
        binder.registerBean(Bean1::class)
        binder.registerBean(DefaultBean2::class)
        binder.registerBean(CustomBean2::class)
        binder.registerBean(TestBean2::class)
        binder.registerBean(ExampleCommand::class)
        binder.registerBean(DefaultArgs::class)
        binder.registerBean(DefaultCommandExecutor::class)
    }
}

class ExampleCommand : Command {
    override val name: String = "example"

    override fun run(arguments: CommandArguments): CommandResult {
        println("!!!!!Running Example command.")
        return SuccessResult("Successful run example command.")
    }
}