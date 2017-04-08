package by.heap.komodo.command

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultCommandExecutor(val commands: List<Command>) : CommandExecutor {
    override fun execute(name: String): CommandResult {
        val command = commands.find { it.name == name }

        return (command ?: NoopCommand).run(CommandArguments())
    }
}

object NoopCommand : Command {
    override val name: String = "noop"

    override fun run(arguments: CommandArguments): CommandResult {
        println("Noop command.")
        return SuccessResult("Noop command.")
    }
}