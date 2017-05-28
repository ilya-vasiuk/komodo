package by.heap.komodo.config

import by.heap.komodo.common.InputStreamProvider

/**
 * Provides configuration data.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KomodoConfigurationSources {
    fun getSources(): List<InputStreamProvider>
}