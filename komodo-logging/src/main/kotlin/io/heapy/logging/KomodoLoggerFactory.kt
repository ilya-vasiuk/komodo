package io.heapy.logging

import org.slf4j.ILoggerFactory


/**
 * Licecycle methods.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KomodoLoggerFactory : ILoggerFactory {
    fun initialize()
}
