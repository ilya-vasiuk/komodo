package io.heapy.komodo.config

import io.heapy.komodo.file.InputStreamProvider

/**
 * Provides configuration data.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KomodoConfigurationSources {
    fun getSources(): List<InputStreamProvider>
}
