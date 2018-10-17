package io.heapy.komodo.console

/**
 * Console represents terminal, to which we can print messages.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Console {
    fun print(msg: io.heapy.komodo.console.ConsoleMessage)

    fun println(msg: io.heapy.komodo.console.ConsoleMessage)

    fun readPassword(): CharArray
}
