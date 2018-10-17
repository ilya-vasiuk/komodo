@file:JvmName("Hello")

package io.heapy.komodo.command

import org.funktionale.either.Either


/**
 * Base command interface
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Command<out R> {
    val name: String
    fun run(arguments: io.heapy.komodo.command.CommandArguments): Either<Exception, R>
}

class CommandArguments

