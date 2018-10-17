
import io.heapy.komodo.di.Binder
import io.heapy.komodo.di.Module
import io.heapy.komodo.scripting.ScriptingModule

class ConfigurationModule : Module {
    override val requires = setOf(ScriptingModule::class)

    override fun assemble(binder: Binder) {
    }
}

ConfigurationModule::class
