package io.heapy.komodo.command

import org.funktionale.either.Either

/**
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultCommandExecutor(
    private val commands: List<io.heapy.komodo.command.Command<*>>
) : io.heapy.komodo.command.CommandExecutor {
    override fun <R> execute(name: String): Either<Exception, R> {
        val command = commands.find { it.name == name }

        return (command ?: io.heapy.komodo.command.NoopCommand).run(io.heapy.komodo.command.CommandArguments()) as Either<Exception, R>
    }
}

object NoopCommand : io.heapy.komodo.command.Command<String> {
    override val name: String = "noop"

    override fun run(arguments: io.heapy.komodo.command.CommandArguments): Either<Exception, String> {
        println("Noop command.")
        return Either.right("Noop command.")
    }
}
