package io.heapy.komodo.core.concurent

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * Thread factory which uses [AtomicInteger] to generate thread ids.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class KomodoThreadFactory(
    private val nameProducer: ThreadNameProducer = { "komodo-$it" },
    private val isDaemon: Boolean = false
) : ThreadFactory {
    private val counter = AtomicInteger()

    override fun newThread(runnable: Runnable): Thread {
        val id = counter.incrementAndGet()

        return Thread(runnable).also {
            it.name = nameProducer(id)
            it.isDaemon = isDaemon
        }
    }
}

internal typealias ThreadNameProducer = (counter: Int) -> String
