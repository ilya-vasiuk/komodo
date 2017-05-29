package by.heap.komodo.samples

import by.heap.komodo.Binder
import by.heap.komodo.Module
import by.heap.komodo.args.DefaultArgs
import by.heap.komodo.command.Command
import by.heap.komodo.command.CommandArguments
import by.heap.komodo.command.CommandResult
import by.heap.komodo.command.DefaultCommandExecutor
import by.heap.komodo.command.SuccessResult
import by.heap.komodo.config.ConfigModule
import by.heap.komodo.config.KomodoConfiguration
import by.heap.komodo.kmd


// http://pholser.github.io/jopt-simple/
// http://commons.apache.org/proper/commons-cli/

// http://picocontainer.com/injection.html
// https://salomonbrys.github.io/Kodein/
// http://docs.spring.io/spring-framework/docs/5.0.0.M5/spring-framework-reference/htmlsingle/#spring-introduction
// http://pholser.github.io/jopt-simple/
// http://www.jcommander.org/
// https://github.com/fusesource/jansi

// https://github.com/airlift/airline
// http://www.jcommander.org/#_overview
// http://docs.spring.io/spring-boot/docs/1.3.5.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
fun main(args: Array<String>) {
    kmd {
        module(TestModule1::class)
        module(ConfigModule::class)
        args(args)
        run()
        command {
            println("config: " + it.getBean(KomodoConfiguration::class).getConfig(SimpleConfig::class))
        }
    }
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

data class SimpleConfig(val profile: String, val password: ByteArray)
