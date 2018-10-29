package io.heapy.komodo.core.time.unit

/**
 * Represent time in milliseconds.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class Milliseconds(
    val millis: Long
)

/**
 * Represent time in seconds.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class Seconds(
    val seconds: Long
)

/**
 * Converts seconds to milliseconds.
 */
fun Seconds.toMillis(): Milliseconds = Milliseconds(this.seconds * 1000)

/**
 * Represent time in minutes.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class Minutes(
    val minutes: Long
)

/**
 * Converts minutes to seconds.
 */
fun Minutes.toSeconds(): Seconds = Seconds(this.minutes * 60)


/**
 * Converts minutes to milliseconds.
 */
fun Minutes.toMillis(): Milliseconds = Milliseconds(this.minutes * 1000 * 60)
