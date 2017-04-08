
package by.heap.komodo.command

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface CommandExecutor {
    fun execute(name: String): CommandResult
}