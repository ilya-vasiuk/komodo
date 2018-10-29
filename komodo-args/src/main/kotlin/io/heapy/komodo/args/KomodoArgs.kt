package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KomodoArgs {
    val args: List<String>
}

class DefaultKomodoArgs(
    override val args: List<String>
) : io.heapy.komodo.args.KomodoArgs
