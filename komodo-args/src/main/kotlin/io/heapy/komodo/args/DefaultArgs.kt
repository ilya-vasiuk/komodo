package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class DefaultArgs : io.heapy.komodo.args.Args {
    override fun getCommand(args: List<String>): String {
        return args.getOrNull(0) ?: "noop"
    }
}
