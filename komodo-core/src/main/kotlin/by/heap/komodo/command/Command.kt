package by.heap.komodo.command


/**
 * Base command interface
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Command {
    val name: String
    fun run(arguments: CommandArguments): CommandResult
}

class CommandArguments

sealed class CommandResult

data class SuccessResult(val message: String = "") : CommandResult()
data class FailureResult(
    val message: String = "",
    val exitCode: Int = 0,
    val exception: Throwable? = null
): CommandResult()


