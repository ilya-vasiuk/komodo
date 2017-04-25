package by.heap.komodo.scripting

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.InputStream

/**
 * Default implementation which used [KotlinJsr223JvmLocalScriptEngineFactory].
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultKotlinScriptCompiler : KotlinScriptCompiler {
    private val factory = KotlinJsr223JvmLocalScriptEngineFactory()
    private val scriptEngine = factory.scriptEngine

    @Suppress("UNCHECKED_CAST")
    override fun <T> execute(inputStream: InputStream): T {
        return scriptEngine.eval(inputStream.reader()) as T
    }
}