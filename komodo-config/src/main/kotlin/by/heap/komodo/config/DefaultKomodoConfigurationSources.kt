package by.heap.komodo.config

import by.heap.komodo.args.KmdArgs
import by.heap.komodo.common.InputStreamProvider
import by.heap.komodo.common.getInputStreamProvider

class DefaultKomodoConfigurationSources(
    private val args: KmdArgs
    // private val cmdParser: Parser// or KmdOptions
) : KomodoConfigurationSources {
    override fun getSources(): List<InputStreamProvider> {
        // TODO: Parse args and provide real config
        return listOf(getInputStreamProvider("classpath:config.kts"))
    }
}