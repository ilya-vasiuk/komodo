package by.heap.komodo.common

import java.io.InputStream

/**
 * Provider for resources located in classpath.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class ClasspathInputStreamProvider(private val path: String) : InputStreamProvider {
    override fun getInputStream(): InputStream {
        val stream: InputStream? = ClasspathInputStreamProvider::class.java.classLoader.getResourceAsStream(path)
        return stream ?: throw KomodoException("CORE-1")
    }
}
