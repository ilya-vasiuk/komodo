package io.heapy.komodo.file

import java.io.InputStream

/**
 * Provider for resources located in classpath.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class ClasspathInputStreamProvider(
    private val path: String
) : io.heapy.komodo.file.InputStreamProvider {
    override fun getInputStream(): InputStream {
        val stream: InputStream? = io.heapy.komodo.file.ClasspathInputStreamProvider::class.java.classLoader.getResourceAsStream(path)
        return stream ?: throw io.heapy.komodo.exceptions.KomodoException("CORE-1")
    }
}
