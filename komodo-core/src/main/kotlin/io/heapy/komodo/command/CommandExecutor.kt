package io.heapy.komodo.command

import org.funktionale.either.Either

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface CommandExecutor {
    fun <R> execute(name: String): Either<Exception, R>
}
