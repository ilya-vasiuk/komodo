package by.heap.komodo.di.default

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
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

        // Since
        assertThrows(KotlinReflectionInternalError::class.java) {
            val result = lambda.reflect()?.call("Hello ", 42)
            assertEquals("Hello 42", result)
        }
    }
}
