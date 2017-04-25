package by.heap.komodo.common

import java.io.IOException
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Provider for resources located in filesystem.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class FileSystemInputStreamProvider(private val path: String) : InputStreamProvider {
    override fun getInputStream(): InputStream {
        return try {
            Files.newInputStream(Paths.get(path))
        } catch (e: IOException) {
            throw KomodoException("CORE-1")
        }
    }
}
