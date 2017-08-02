package by.heap.komodo.command

import by.heap.komodo.di.moduleOf

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
val commandModule = moduleOf {
    registerBean(DefaultCommandExecutor::class)
}