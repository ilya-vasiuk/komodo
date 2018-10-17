package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KomodoArgs {
    val args: List<String>
}

class DefaultKomodoArgs(
    override val args: List<String>
) : io.heapy.komodo.args.KomodoArgs
