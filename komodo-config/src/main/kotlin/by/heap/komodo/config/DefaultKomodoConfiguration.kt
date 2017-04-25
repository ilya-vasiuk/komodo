package by.heap.komodo.config

import by.heap.komodo.common.KomodoException
import by.heap.komodo.common.getInputStreamProvider
import by.heap.komodo.scripting.KotlinScriptCompiler
import kotlin.reflect.KClass

/**
 * Default implementation if komodo configuration.
 *
 * I assume that you’re using one of the example JSR223 projects, e.g. https://github.com/JetBrains/kotlin/tree/1.1.0/libraries/examples/kotlin-jsr223-daemon-local-eval-example. You need to create a similar one, but use your own factory, by copying and modifying this one - https://github.com/JetBrains/kotlin/blob/1.1.0/libraries/tools/kotlin-script-util/src/main/kotlin/org/jetbrains/kotlin/script/jsr223/KotlinJsr223ScriptEngineFactoryExamples.kt#L49
In particular you need to replace call to `scriptCompilationClasspathFromContext`, with the minimal classpath needed for your script. You need to make sure that at least `kotlin-script-runtime` and java stdlib is included there.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultKomodoConfiguration(val kotlinScriptCompiler: KotlinScriptCompiler) : KomodoConfiguration {
//    private val configs = mapOf<KClass<*>, Any>()
    private val configs: Map<KClass<*>, Any> by lazy {
        val any = kotlinScriptCompiler.execute<Any>(getInputStreamProvider("classpath:mvn.kts").getInputStream())

        mapOf(any::class to any)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> getConfig(klass: KClass<T>): T? {
        return try {
            configs[klass] as T?
        } catch (e: ClassCastException) {
            throw KomodoException("CORE-2")
        }
    }
}




