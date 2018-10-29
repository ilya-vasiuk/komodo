package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface KomodoEnv {
    val env: Map<String, String>
}

class DefaultKomodoEnv(
    override val env: Map<String, String>
) : io.heapy.komodo.args.KomodoEnv
