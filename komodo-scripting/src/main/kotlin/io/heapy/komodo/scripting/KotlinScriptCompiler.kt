package io.heapy.komodo.scripting

import java.io.InputStream

/**
 * Reads script from input stream and executes it.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KotlinScriptCompiler {
    suspend fun <T> execute(inputStream: InputStream): T
    suspend fun <T> execute(script: String): T
}
