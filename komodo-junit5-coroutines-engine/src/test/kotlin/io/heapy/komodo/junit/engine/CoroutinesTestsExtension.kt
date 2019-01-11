package io.heapy.komodo.junit.engine

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestInstanceFactory
import org.junit.jupiter.api.extension.TestInstanceFactoryContext

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
class CoroutinesTestsExtension : TestInstanceFactory {
    override fun createTestInstance(factoryContext: TestInstanceFactoryContext, extensionContext: ExtensionContext): Any {
        return SampleTest()
    }
}


class SampleTest {

    @Test
    fun `sample test`() {
        Assertions.assertEquals("hello, world", "hello" + ", world")
    }

    @Test
    suspend fun `co sample test`() {
    }
}
