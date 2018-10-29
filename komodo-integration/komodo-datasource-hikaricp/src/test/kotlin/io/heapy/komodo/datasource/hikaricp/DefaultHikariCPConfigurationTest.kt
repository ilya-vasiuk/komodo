package io.heapy.komodo.datasource.hikaricp

import io.heapy.komodo.core.time.unit.Seconds
import io.heapy.komodo.core.time.unit.toMillis
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadFactory
import javax.sql.DataSource

/**
 * @author Ruslan Ibragimov
 * @since 1.0
 */
internal class DefaultHikariCPConfigurationTest {

    @Test
    fun `test configuration populated`() {
        val dataSource = mockk<DataSource>()
        val threadFactory = mockk<ThreadFactory>()
        val scheduledExecutor = mockk<ScheduledExecutorService>()
        val config = DefaultHikariCPConfiguration(
            dataSource = dataSource,
            dataSourceClassName = "dataSourceClassName",
            jdbcUrl = "jdbcUrl",
            allowPoolSuspension = false,
            username = "username",
            password = "password",
            autoCommit = false,
            connectionTimeout = Seconds(1).toMillis(),
            idleTimeout = Seconds(2).toMillis(),
            maxLifetime = Seconds(3).toMillis(),
            connectionTestQuery = "connectionTestQuery",
            minimumIdle = 1,
            maximumPoolSize = 2,
            poolName = "poolName",
            initializationFailTimeout = Seconds(4).toMillis(),
            isolateInternalQueries = false,
            readOnly = true,
            registerMbeans = false,
            catalog = "catalog",
            connectionInitSql = "connectionInitSql",
            driverClassName = "io.heapy.komodo.datasource.hikaricp.DefaultHikariConnectionPoolConfiguration",
            transactionIsolation = "transactionIsolation",
            validationTimeout = Seconds(5).toMillis(),
            leakDetectionThreshold = Seconds(6).toMillis(),
            schema = "schema",
            threadFactory = threadFactory,
            scheduledExecutor = scheduledExecutor
        ).toHikariConfig()

        assertAll(
            { assertEquals(dataSource, config.dataSource) },
            { assertEquals("dataSourceClassName", config.dataSourceClassName) },
            { assertEquals("jdbcUrl", config.jdbcUrl) },
            { assertEquals("username", config.username) },
            { assertEquals("password", config.password) },
            { assertEquals(false, config.isAutoCommit) },
            { assertEquals(1_000, config.connectionTimeout) },
            { assertEquals(2_000, config.idleTimeout) },
            { assertEquals(3_000, config.maxLifetime) },
            { assertEquals("connectionTestQuery", config.connectionTestQuery) },
            { assertEquals(1, config.minimumIdle) },
            { assertEquals(2, config.maximumPoolSize) },
            { assertEquals("poolName", config.poolName) },
            { assertEquals(4_000, config.initializationFailTimeout) },
            { assertEquals(false, config.isIsolateInternalQueries) },
            { assertEquals(false, config.isAllowPoolSuspension) },
            { assertEquals(true, config.isReadOnly) },
            { assertEquals(false, config.isRegisterMbeans) },
            { assertEquals("catalog", config.catalog) },
            { assertEquals("connectionInitSql", config.connectionInitSql) },
            { assertEquals("io.heapy.komodo.datasource.hikaricp.DefaultHikariConnectionPoolConfiguration", config.driverClassName) },
            { assertEquals("transactionIsolation", config.transactionIsolation) },
            { assertEquals(5_000, config.validationTimeout) },
            { assertEquals(6_000, config.leakDetectionThreshold) },
            { assertEquals("schema", config.schema) },
            { assertEquals(threadFactory, config.threadFactory) },
            { assertEquals(scheduledExecutor, config.scheduledExecutor) }
        )
    }
}
