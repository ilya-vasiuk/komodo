package io.heapy.komodo.command

import org.funktionale.either.Either

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface CommandExecutor {
    fun <R> execute(name: String): Either<Exception, R>
}
