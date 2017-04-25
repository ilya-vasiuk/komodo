package by.heap.komodo.common

import java.io.InputStream

private const val CLASSPATH_PREFIX = "classpath:"

/**
 * Interface for classes which can provide input stream
 * of their content.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
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
    path.startsWith(CLASSPATH_PREFIX) -> ClasspathInputStreamProvider(path.removePrefix(CLASSPATH_PREFIX))
    else -> FileSystemInputStreamProvider(path)
}