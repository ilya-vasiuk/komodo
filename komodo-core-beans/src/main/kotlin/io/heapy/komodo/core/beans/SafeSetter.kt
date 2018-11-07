package io.heapy.komodo.core.beans

import io.heapy.komodo.experimental.ExperimentalApi

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
@ExperimentalApi
inline fun <T> setIfNotNull(setter: (T) -> Unit, value: T?) {
    if (value != null) {
        setter(value)
    }
}

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
@ExperimentalApi
inline fun <T, R> T?.ifNotNull(block: (T) -> R): R? {
    return if (this != null) {
        block(this)
    } else {
        null
    }
}
