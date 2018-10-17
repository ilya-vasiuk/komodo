package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultArgs : io.heapy.komodo.args.Args {
    override fun getCommand(args: List<String>): String {
        return args.getOrNull(0) ?: "noop"
    }
}
