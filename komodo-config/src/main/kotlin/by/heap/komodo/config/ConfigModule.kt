package by.heap.komodo.config

import by.heap.komodo.Binder
import by.heap.komodo.Module
import by.heap.komodo.scripting.DefaultKotlinScriptCompiler

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class ConfigModule : Module {
    override fun configure(binder: Binder) {
        binder.registerBean(DefaultKotlinScriptCompiler::class)
        binder.registerBean(DefaultKomodoConfiguration::class)
        binder.registerBean(DefaultKomodoConfigurationSources::class)
    }
}