package io.heapy.komodo.console

import io.heapy.komodo.exceptions.KomodoException
import java.io.IOException

/**
 * Default implmentation of console.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class DefaultConsole : io.heapy.komodo.console.Console {
    override fun print(msg: io.heapy.komodo.console.ConsoleMessage) {
        print(msg.message)
    }

    override fun println(msg: io.heapy.komodo.console.ConsoleMessage) {
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
