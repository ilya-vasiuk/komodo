package io.heapy.komodo.exceptions

/**
 * Base class for library exceptions with code for more readable errors.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoException(val code: String) : RuntimeException() {
    override fun toString(): String {
        return "KomodoException(code='$code')"
    }
}
