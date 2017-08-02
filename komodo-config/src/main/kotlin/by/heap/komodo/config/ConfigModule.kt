package by.heap.komodo.config

import by.heap.komodo.di.moduleOf
import by.heap.komodo.scripting.DefaultKotlinScriptCompiler

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
val configModule = moduleOf {
    registerBean(DefaultKotlinScriptCompiler::class)
    registerBean(DefaultKomodoConfiguration::class)
    registerBean(DefaultKomodoConfigurationSources::class)
}