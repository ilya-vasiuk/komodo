package io.heapy.logging

import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.event.Level

/**
 * Saves all log events until logging system is configured by framework,
 * or log all available messages to standard output, in case if startup failed
 * and logging system is not available.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class EventRecordingStartupLogger(
    private val name: String,
    val eventQueue: MutableCollection<KLoggingEvent>
) : Logger {
    internal fun recordEvent(
        level: Level,
        marker: Marker? = null,
        msg: String?,
        args: Array<out Any?>?,
        throwable: Throwable?
    ) {
        eventQueue.add(DefaultKLoggingEvent(
            kLevel = level,
            kMarker = marker,
            kLoggerName = name,
            kThreadName = Thread.currentThread().name,
            kMessage = msg,
            kArgArray = args,
            kTimeStamp = System.currentTimeMillis(),
            kThrowable = throwable
        ))
    }

    override fun trace(msg: String?) {
        recordEvent(level = Level.TRACE, msg = msg, args = null, throwable = null)
    }

    override fun trace(format: String?, arg: Any?) {
        recordEvent(level = Level.TRACE, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.TRACE, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.TRACE, msg = format, args = arguments, throwable = null)
    }

    override fun trace(msg: String?, t: Throwable?) {
        recordEvent(level = Level.TRACE, msg = msg, args = null, throwable = t)
    }

    override fun trace(marker: Marker?, msg: String?) {
        recordEvent(level = Level.TRACE, marker = marker, msg = msg, args = null, throwable = null)
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        recordEvent(level = Level.TRACE, marker = marker, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.TRACE, marker = marker, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun trace(marker: Marker?, format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.TRACE, marker = marker, msg = format, args = arguments, throwable = null)
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        recordEvent(level = Level.TRACE, marker = marker, msg = msg, args = null, throwable = t)
    }

    override fun debug(msg: String?) {
        recordEvent(level = Level.DEBUG, msg = msg, args = null, throwable = null)
    }

    override fun debug(format: String?, arg: Any?) {
        recordEvent(level = Level.DEBUG, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.DEBUG, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.DEBUG, msg = format, args = arguments, throwable = null)
    }

    override fun debug(msg: String?, t: Throwable?) {
        recordEvent(level = Level.DEBUG, msg = msg, args = null, throwable = t)
    }

    override fun debug(marker: Marker?, msg: String?) {
        recordEvent(level = Level.DEBUG, marker = marker, msg = msg, args = null, throwable = null)
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        recordEvent(level = Level.DEBUG, marker = marker, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.DEBUG, marker = marker, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.DEBUG, marker = marker, msg = format, args = arguments, throwable = null)
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        recordEvent(level = Level.DEBUG, marker = marker, msg = msg, args = null, throwable = t)
    }

    override fun info(msg: String?) {
        recordEvent(level = Level.INFO, msg = msg, args = null, throwable = null)
    }

    override fun info(format: String?, arg: Any?) {
        recordEvent(level = Level.INFO, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.INFO, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun info(format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.INFO, msg = format, args = arguments, throwable = null)
    }

    override fun info(msg: String?, t: Throwable?) {
        recordEvent(level = Level.INFO, msg = msg, args = null, throwable = t)
    }

    override fun info(marker: Marker?, msg: String?) {
        recordEvent(level = Level.INFO, marker = marker, msg = msg, args = null, throwable = null)
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        recordEvent(level = Level.INFO, marker = marker, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.INFO, marker = marker, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.INFO, marker = marker, msg = format, args = arguments, throwable = null)
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        recordEvent(level = Level.INFO, marker = marker, msg = msg, args = null, throwable = t)
    }

    override fun warn(msg: String?) {
        recordEvent(level = Level.WARN, msg = msg, args = null, throwable = null)
    }

    override fun warn(format: String?, arg: Any?) {
        recordEvent(level = Level.WARN, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.WARN, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.WARN, msg = format, args = arguments, throwable = null)
    }

    override fun warn(msg: String?, t: Throwable?) {
        recordEvent(level = Level.WARN, msg = msg, args = null, throwable = t)
    }

    override fun warn(marker: Marker?, msg: String?) {
        recordEvent(level = Level.WARN, marker = marker, msg = msg, args = null, throwable = null)
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        recordEvent(level = Level.WARN, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.WARN, marker = marker, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.WARN, marker = marker, msg = format, args = arguments, throwable = null)
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        recordEvent(level = Level.WARN, marker = marker, msg = msg, args = null, throwable = t)
    }

    override fun error(msg: String?) {
        recordEvent(level = Level.ERROR, msg = msg, args = null, throwable = null)
    }

    override fun error(format: String?, arg: Any?) {
        recordEvent(level = Level.ERROR, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.ERROR, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun error(format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.ERROR, msg = format, args = arguments, throwable = null)
    }

    override fun error(msg: String?, t: Throwable?) {
        recordEvent(level = Level.ERROR, msg = msg, args = null, throwable = t)
    }

    override fun error(marker: Marker?, msg: String?) {
        recordEvent(level = Level.ERROR, marker = marker, msg = msg, args = null, throwable = null)
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        recordEvent(level = Level.ERROR, marker = marker, msg = format, args = arrayOf(arg), throwable = null)
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        recordEvent(level = Level.ERROR, marker = marker, msg = format, args = arrayOf(arg1, arg2), throwable = null)
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        recordEvent(level = Level.ERROR, marker = marker, msg = format, args = arguments, throwable = null)
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        recordEvent(level = Level.ERROR, marker = marker, msg = msg, args = null, throwable = t)
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
