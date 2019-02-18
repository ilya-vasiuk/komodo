package io.heapy.logging.logback

import io.heapy.logging.DelegatingLogger
import io.heapy.logging.EventRecordingStartupLogger
import io.heapy.logging.KLoggingEvent
import io.heapy.logging.KomodoLoggerFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Creates instance of logger which delegates call to startup or runtime logger.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class LogbackKomodoLoggerFactory : KomodoLoggerFactory {
    private val loggerMap = ConcurrentHashMap<String, Logger>()
    private var initialized = false

    override fun initialize() {
        initialized = true
        loggerMap.values
            .filterIsInstance<DelegatingLogger>()
            .forEach {
                val logger = it.logger
                if (logger is EventRecordingStartupLogger) {
                    val newLogger = LoggerFactory.getLogger(it.name)
                    it.logger = newLogger

                    if (newLogger is ch.qos.logback.classic.Logger) {
                        logger.eventQueue.forEach { event ->
                            // TODO: Doesn't respect thread name and real timestamp,
                            //       so we shouldn't use it
                            newLogger.log(event)
                        }
                    }
                }
            }
    }

    override fun getLogger(name: String): Logger {
        val komodoLogger = loggerMap[name]

        return if (komodoLogger != null) {
            komodoLogger
        } else {
            val newInstance: Logger = if (initialized) {
                LoggerFactory.getLogger(name)
            } else {
                DelegatingLogger(logger = EventRecordingStartupLogger(name, ConcurrentLinkedQueue<KLoggingEvent>()))
            }
            val oldInstance = loggerMap.putIfAbsent(name, newInstance)
            oldInstance ?: newInstance
        }
    }

}
