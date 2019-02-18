package io.heapy.logging

import org.slf4j.Logger

/**
 * Represent log request sent to startup logger.
 */
typealias LogRequest = (Logger) -> Unit

/**
 * Startup logger doesn't do any actual work and just saves logging requests
 * until real logger passed
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface StartupLogger : Logger {

    /**
     * Log all saved events thought passed logger
     */
    fun replayEvents(logger: Logger)
}


