package io.heapy.komodo.di.default

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError
import kotlin.reflect.jvm.reflect


/**
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class LambdaReflectionTest {

    @Test
    fun `introspecting lambdas`() {
        val lambda = { a: String, b: Int -> a + b }

        // Since feature not yet implemented in Kotlin
        assertThrows<KotlinReflectionInternalError> {
            val result = lambda.reflect()?.call("Hello ", 42)
            assertEquals("Hello 42", result)
        }
    }
}
