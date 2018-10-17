package io.heapy.komodo.args

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface KomodoEnv {
    val env: Map<String, String>
}

class DefaultKomodoEnv(
    override val env: Map<String, String>
) : io.heapy.komodo.args.KomodoEnv
