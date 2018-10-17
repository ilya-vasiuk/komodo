package io.heapy.komodo.config

import io.heapy.komodo.file.InputStreamProvider

/**
 * Provides configuration data.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KomodoConfigurationSources {
    fun getSources(): List<InputStreamProvider>
}
