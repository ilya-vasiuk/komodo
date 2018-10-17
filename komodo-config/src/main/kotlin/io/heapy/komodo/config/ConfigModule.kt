package io.heapy.komodo.config

import io.heapy.komodo.di.Binder
import io.heapy.komodo.di.Module
import io.heapy.komodo.scripting.DefaultKotlinScriptCompiler
import io.heapy.komodo.scripting.KotlinScriptCompiler

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class ConfigModule : Module {
    override fun assemble(binder: Binder) {
        binder.wire(KotlinScriptCompiler::class).with(DefaultKotlinScriptCompiler::class).override(Module::class)
        binder.wire(io.heapy.komodo.config.KomodoConfiguration::class).with(io.heapy.komodo.config.DefaultKomodoConfiguration::class)
        binder.wire(io.heapy.komodo.config.KomodoConfigurationSources::class).with(io.heapy.komodo.config.DefaultKomodoConfigurationSources::class)
    }
}
