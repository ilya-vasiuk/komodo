package io.heapy.komodo.file

import java.io.InputStream

private const val CLASSPATH_PREFIX = "classpath:"

/**
 * TODO: Suspend? Async? Use of coroutines-jdk8
 * Interface for classes which can provide input stream
 * of their content.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface InputStreamProvider {
    /**
     * Returns new input stream for each call or null,
     * if steam could not be open.
     */
    fun getInputStream(): InputStream
}

/**
 * Get input stream provider by path
 */
fun getInputStreamProvider(path: String): InputStreamProvider = when {
    path.startsWith(CLASSPATH_PREFIX) -> io.heapy.komodo.file.ClasspathInputStreamProvider(path.removePrefix(CLASSPATH_PREFIX))
    else -> io.heapy.komodo.file.FileSystemInputStreamProvider(path)
}
