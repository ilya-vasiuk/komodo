package by.heap.komodo.console

import by.heap.komodo.common.KomodoException
import java.io.IOException

/**
 * Default implmentation of console.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultConsole : Console {
    override fun print(msg: ConsoleMessage) {
        print(msg.message)
    }

    override fun println(msg: ConsoleMessage) {
        println(msg.message)
    }

    override fun readPassword(): CharArray {
        try {
            // Do not close the readers since System.in should not be closed
            return readLine()?.toCharArray() ?: throw KomodoException("CONSOLE-1")
        } catch (e: IOException) {
            throw KomodoException("CONSOLE-2")
        }
    }
}
