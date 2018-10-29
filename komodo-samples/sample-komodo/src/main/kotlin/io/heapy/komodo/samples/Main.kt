package io.heapy.komodo.samples

import io.heapy.komodo.di.Module
import io.heapy.komodo.scripting.DefaultKotlinScriptCompiler
import kotlinx.coroutines.runBlocking
import kotlin.reflect.KClass

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val script = Main::class.java.classLoader.getResourceAsStream("configuration.kts")
            .reader().readText()
        runBlocking {
            val module = DefaultKotlinScriptCompiler().execute<KClass<out Module>>(script)
            println(module)
        }
    }
}
