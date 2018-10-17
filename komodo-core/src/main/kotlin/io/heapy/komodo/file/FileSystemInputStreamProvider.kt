package io.heapy.komodo.file

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
class FileSystemInputStreamProvider(
    private val path: String
) : io.heapy.komodo.file.InputStreamProvider {
    override fun getInputStream(): InputStream {
        return try {
            Files.newInputStream(Paths.get(path))
        } catch (e: IOException) {
            throw io.heapy.komodo.exceptions.KomodoException("CORE-1")
        }
    }
}
