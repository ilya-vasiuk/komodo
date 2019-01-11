package io.heapy.komodo.datasource.hikaricp

import com.zaxxer.hikari.metrics.MetricsTrackerFactory
import io.heapy.komodo.core.time.unit.Milliseconds
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadFactory
import javax.sql.DataSource

/**
 * Default implementation of [HikariCPConfiguration].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
data class DefaultHikariCPConfiguration(
    override val dataSource: DataSource? = null,

    override val dataSourceClassName: String? = null,
    override val jdbcUrl: String? = null,
    override val username: String? = null,
    override val password: String? = null,

    override val autoCommit: Boolean? = null,
    override val connectionTimeout: Milliseconds? = null,
    override val idleTimeout: Milliseconds? = null,
    override val maxLifetime: Milliseconds? = null,

    override val connectionTestQuery: String? = null,
    override val minimumIdle: Int? = null,
    override val maximumPoolSize: Int? = null,

    override val metricRegistry: Any? = null,
    override val metricsTrackerFactory: MetricsTrackerFactory? = null,
    override val healthCheckRegistry: Any? = null,

    override val poolName: String? = null,

    override val initializationFailTimeout: Milliseconds? = null,

    override val isolateInternalQueries: Boolean? = null,
    override val allowPoolSuspension: Boolean? = null,
    override val readOnly: Boolean? = null,
    override val registerMbeans: Boolean? = null,

    override val catalog: String? = null,
    override val connectionInitSql: String? = null,
    override val driverClassName: String? = null,
    override val transactionIsolation: String? = null,

    override val validationTimeout: Milliseconds? = null,
    override val leakDetectionThreshold: Milliseconds? = null,

    override val schema: String? = null,
    override val threadFactory: ThreadFactory? = null,
    override val scheduledExecutor: ScheduledExecutorService? = null
) : HikariCPConfiguration
