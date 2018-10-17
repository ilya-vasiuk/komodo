package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Args {
    fun getCommand(args: List<String>): String
}
