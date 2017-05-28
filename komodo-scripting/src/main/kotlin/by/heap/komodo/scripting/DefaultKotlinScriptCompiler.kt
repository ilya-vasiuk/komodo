package by.heap.komodo.scripting

import kotlinx.coroutines.experimental.future.await
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.InputStream
import java.util.concurrent.CompletableFuture

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
    suspend override fun <T> execute(inputStream: InputStream): T {
        // TODO: Is scriptEngine thread safe?
        return CompletableFuture.supplyAsync { scriptEngine.eval(inputStream.reader()) as T }.await()
    }
}