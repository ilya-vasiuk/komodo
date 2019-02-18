package io.heapy.logging

import org.slf4j.Marker
import org.slf4j.event.Level
import org.slf4j.event.LoggingEvent

/**
 * Specifies nullability guarantees missed in [LoggingEvent].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KLoggingEvent : LoggingEvent {
    override fun getLevel(): Level
    override fun getMarker(): Marker?
    override fun getLoggerName(): String
    override fun getThreadName(): String
    override fun getMessage(): String?
    override fun getArgumentArray(): Array<out Any?>?
    override fun getTimeStamp(): Long
    override fun getThrowable(): Throwable?
}

/**
 * Default implementation of [KLoggingEvent].
 *
 * prefix `k` - for Kotlin,
 * because we can't override java methods **KT-6653**
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
internal class DefaultKLoggingEvent(
    private val kLevel: Level,
    private val kMarker: Marker?,
    private val kLoggerName: String,
    private val kThreadName: String,
    private val kMessage: String?,
    private val kArgArray: Array<out Any?>?,
    private val kTimeStamp: Long,
    private val kThrowable: Throwable?
) : KLoggingEvent {
    override fun getLevel(): Level = kLevel
    override fun getMarker(): Marker? = kMarker
    override fun getLoggerName(): String = kLoggerName
    override fun getThreadName(): String = kThreadName
    override fun getMessage(): String? = kMessage
    override fun getArgumentArray(): Array<out Any?>? = kArgArray
    override fun getTimeStamp(): Long = kTimeStamp
    override fun getThrowable(): Throwable? = kThrowable
}
