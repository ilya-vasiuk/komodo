package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Args {
    fun getCommand(args: List<String>): String
}
