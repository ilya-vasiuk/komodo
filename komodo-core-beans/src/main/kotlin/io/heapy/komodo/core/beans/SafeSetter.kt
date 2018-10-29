package io.heapy.komodo.core.beans

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
inline fun <T> setIfNotNull(setter: (T) -> Unit, value: T?) {
    if (value != null) {
        setter(value)
    }
}
