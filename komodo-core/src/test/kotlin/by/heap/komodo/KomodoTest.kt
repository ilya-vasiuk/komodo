package by.heap.komodo

import by.heap.komodo.args.DefaultKmdArgs
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.jvm.reflect

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class KomodoTest {
    @[Test DisplayName("😍 Komodo Test")] fun test() {
        assertTrue(1 === 1)
    }
}

fun main(args: Array<String>) {
    val provider: Function<*> = { DefaultKmdArgs(listOf(*args)) }
    val constructor = provider.reflect() ?: throw RuntimeException("Can't introspect provider: $provider.")
    constructor.call()
}
