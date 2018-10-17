package io.heapy.komodo.scripting

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.newSingleThreadContext
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.InputStream
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Default implementation which used [KotlinJsr223JvmLocalScriptEngineFactory].
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultKotlinScriptCompiler(
    private val context: CoroutineContext = newSingleThreadContext("DefaultKotlinScriptCompiler")
) : KotlinScriptCompiler {
    private val factory = KotlinJsr223JvmLocalScriptEngineFactory()
    private val scriptEngine = factory.scriptEngine

    override suspend fun <T> execute(inputStream: InputStream): T {
        return GlobalScope.async(context = context) {
            @Suppress("UNCHECKED_CAST")
            scriptEngine.eval(inputStream.reader()) as T
        }.await()
    }

    override suspend fun <T> execute(script: String): T {
        return GlobalScope.async(context = context) {
            @Suppress("UNCHECKED_CAST")
            scriptEngine.eval(script) as T
        }.await()
    }
}
