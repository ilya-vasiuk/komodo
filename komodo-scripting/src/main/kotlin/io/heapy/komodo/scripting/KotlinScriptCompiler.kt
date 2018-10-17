package io.heapy.komodo.scripting

import java.io.InputStream

/**
 * Reads script from input stream and executes it.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KotlinScriptCompiler {
    suspend fun <T> execute(inputStream: InputStream): T
    suspend fun <T> execute(script: String): T
}
