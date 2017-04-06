package by.heap.komodo

/**
 * Base command interface
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Command {
    fun run(arguments: CommandArguments): CommandResult
}

class CommandArguments

sealed class CommandResult

data class Success(val message: String = "") : CommandResult()
data class Failure(
    val message: String = "",
    val exitCode: Int = 0,
    val exception: Throwable? = null
): CommandResult()


