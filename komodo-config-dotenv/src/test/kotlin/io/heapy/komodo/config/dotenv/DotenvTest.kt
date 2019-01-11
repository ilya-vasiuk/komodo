package io.heapy.komodo.config.dotenv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.nio.file.Paths

/**
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class DotenvTest {

    @Test
    fun `ignore if missing`() {
        assertNull(Dotenv().getOrNull("NO_SUCH_ENV"))
    }

    @Test
    fun `do not ignore if missing`() {
        assertThrows<DotenvFileNotFoundException> {
            Dotenv(ignoreIfMissing = false).getOrNull("NO_SUCH_ENV")
        }
    }

    @Test
    fun `should throw exception`() {
        assertThrows<EnvNotDefinedException> {
            Dotenv().get("NO_SUCH_ENV")
        }
    }

    @Test
    fun `loads by providing file name`() {
        val dotenv = Dotenv(Paths.get("./src/test/resources/.env_test"))

        assertEquals("Hello, Komodo!", dotenv.get("TEST_VAR"))
    }

    @Test
    fun `loads by providing env variable`() {
        val dotenv = Dotenv(system = mapOf(
            "KOMODO_DOTENV_FILE" to "./src/test/resources/.env_test"
        ))

        assertEquals("Hello, Komodo!", dotenv.get("TEST_VAR"))
    }
}
