package by.heap.komodo.command

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class CommandModule : by.heap.komodo.Module {
    override fun configure(binder: by.heap.komodo.Binder) {
        binder.registerBean(DefaultCommandExecutor::class)
    }
}
