package io.heapy.logging

import org.slf4j.Logger
import org.slf4j.Marker

/**
 * Just records log params, and loses information about thread name and time.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class SimpleEventRecordingStartupLogger(
    private val name: String
) : StartupLogger {

    private val messages = mutableListOf<LogRequest>()

    override fun replayEvents(logger: Logger) {
        messages.forEach { it(logger) }
        messages.clear()
    }

    override fun warn(msg: String?) {
        messages.add { it.warn(msg) }
    }

    override fun warn(format: String?, arg: Any?) {
        messages.add { it.warn(format, arg) }
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        messages.add { it.warn(format, arguments) }
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.warn(format, arg1, arg2) }
    }

    override fun warn(msg: String?, t: Throwable?) {
        messages.add { it.warn(msg, t) }
    }

    override fun warn(marker: Marker?, msg: String?) {
        messages.add { it.warn(marker, msg) }
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        messages.add { it.warn(marker, format, arg) }
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.warn(marker, format, arg1, arg2) }
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        messages.add { it.warn(marker, format, arguments) }
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        messages.add { it.warn(marker, msg, t) }
    }

    override fun info(msg: String?) {
        messages.add { it.info(msg) }
    }

    override fun info(format: String?, arg: Any?) {
        messages.add { it.info(format, arg) }
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.info(format, arg1, arg2) }
    }

    override fun info(format: String?, vararg arguments: Any?) {
        messages.add { it.info(format, arguments) }
    }

    override fun info(msg: String?, t: Throwable?) {
        messages.add { it.info(msg, t) }
    }

    override fun info(marker: Marker?, msg: String?) {
        messages.add { it.info(marker, msg) }
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        messages.add { it.info(marker, format, arg) }
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.info(marker, format, arg1, arg2) }
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        messages.add { it.info(marker, format, arguments) }
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        messages.add { it.info(marker, msg, t) }
    }

    override fun error(msg: String?) {
        messages.add { it.error(msg) }
    }

    override fun error(format: String?, arg: Any?) {
        messages.add { it.error(format, arg) }
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.error(format, arg1, arg2) }
    }

    override fun error(format: String?, vararg arguments: Any?) {
        messages.add { it.error(format, arguments) }
    }

    override fun error(msg: String?, t: Throwable?) {
        messages.add { it.error(msg, t) }
    }

    override fun error(marker: Marker?, msg: String?) {
        messages.add { it.error(marker, msg) }
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        messages.add { it.error(marker, format, arg) }
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.error(marker, format, arg1, arg2) }
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        messages.add { it.error(marker, format, arguments) }
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        messages.add { it.error(marker, msg, t) }
    }

    override fun debug(msg: String?) {
        messages.add { it.debug(msg) }
    }

    override fun debug(format: String?, arg: Any?) {
        messages.add { it.debug(format, arg) }
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.debug(format, arg1, arg2) }
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        messages.add { it.debug(format, arguments) }
    }

    override fun debug(msg: String?, t: Throwable?) {
        messages.add { it.debug(msg, t) }
    }

    override fun debug(marker: Marker?, msg: String?) {
        messages.add { it.debug(marker, msg) }
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        messages.add { it.debug(marker, format, arg) }
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.debug(marker, format, arg1, arg2) }
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        messages.add { it.debug(marker, format, arguments) }
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        messages.add { it.debug(marker, msg, t) }
    }

    override fun trace(msg: String?) {
        messages.add { it.trace(msg) }
    }

    override fun trace(format: String?, arg: Any?) {
        messages.add { it.trace(format, arg) }
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.trace(format, arg1, arg2) }
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        messages.add { it.trace(format, arguments) }
    }

    override fun trace(msg: String?, t: Throwable?) {
        messages.add { it.trace(msg, t) }
    }

    override fun trace(marker: Marker?, msg: String?) {
        messages.add { it.trace(marker, msg) }
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        messages.add { it.trace(marker, format, arg) }
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        messages.add { it.trace(marker, format, arg1, arg2) }
    }

    override fun trace(marker: Marker?, format: String?, vararg argArray: Any?) {
        messages.add { it.trace(marker, format, argArray) }
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        messages.add { it.trace(marker, msg, t) }
    }

    override fun getName(): String = name
    override fun isErrorEnabled(): Boolean = true
    override fun isErrorEnabled(marker: Marker?): Boolean = true
    override fun isInfoEnabled(): Boolean = true
    override fun isInfoEnabled(marker: Marker?): Boolean = true
    override fun isWarnEnabled(): Boolean = true
    override fun isWarnEnabled(marker: Marker?): Boolean = true
    override fun isDebugEnabled(): Boolean = true
    override fun isDebugEnabled(marker: Marker?): Boolean = true
    override fun isTraceEnabled(): Boolean = true
    override fun isTraceEnabled(marker: Marker?): Boolean = true
}
