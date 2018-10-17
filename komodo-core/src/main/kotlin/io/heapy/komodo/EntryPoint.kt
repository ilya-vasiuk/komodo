package io.heapy.komodo

/**
 * Represents entry point of application.
 *
 * Usually this method runs something like web server or desktop application.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
interface EntryPoint<out R> {
    suspend fun run(): R
}
