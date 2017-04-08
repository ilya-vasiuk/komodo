package by.heap.komodo.console

/**
 * Console represents terminal, to which we can print messages.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface Console {
    fun print(msg: ConsoleMessage)

    fun println(msg: ConsoleMessage)

    fun readPassword(): CharArray
}