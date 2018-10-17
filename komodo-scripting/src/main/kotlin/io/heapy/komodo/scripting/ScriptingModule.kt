package io.heapy.komodo.scripting

import io.heapy.komodo.di.Binder
import io.heapy.komodo.di.Module

/**
 * Module that provides [KotlinScriptCompiler].
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class ScriptingModule : Module {
    override fun assemble(binder: Binder) {
        binder.wire(KotlinScriptCompiler::class).with(DefaultKotlinScriptCompiler())
    }
}
