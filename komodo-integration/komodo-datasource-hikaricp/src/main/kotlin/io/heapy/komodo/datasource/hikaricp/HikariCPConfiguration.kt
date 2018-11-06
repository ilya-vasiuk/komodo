package io.heapy.komodo.datasource.hikaricp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.metrics.MetricsTrackerFactory
import io.heapy.komodo.core.time.unit.Milliseconds
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadFactory
import javax.sql.DataSource

/**
 * Represents configuration of HikariCP.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface HikariCPConfiguration {
    val dataSource: DataSource?

    val dataSourceClassName: String?
    val jdbcUrl: String?
    val username: String?
    val password: String?

    val autoCommit: Boolean?
    val connectionTimeout: Milliseconds?
    val idleTimeout: Milliseconds?
    val maxLifetime: Milliseconds?

    val connectionTestQuery: String?
    val minimumIdle: Int?
    val maximumPoolSize: Int?

    val metricRegistry: Any?
    val metricsTrackerFactory: MetricsTrackerFactory?
    val healthCheckRegistry: Any?

    val poolName: String?

    val initializationFailTimeout: Milliseconds?

    val isolateInternalQueries: Boolean?
    val allowPoolSuspension: Boolean?
    val readOnly: Boolean?
    val registerMbeans: Boolean?

    val catalog: String?
    val connectionInitSql: String?
    val driverClassName: String?
    val transactionIsolation: String?

    val validationTimeout: Milliseconds?
    val leakDetectionThreshold: Milliseconds?

    val schema: String?
    val threadFactory: ThreadFactory?
    val scheduledExecutor: ScheduledExecutorService?

    fun toHikariConfig(): HikariConfig = HikariConfig().also {
        dataSource?.let(it::setDataSource)
        dataSourceClassName?.let(it::setDataSourceClassName)
        jdbcUrl?.let(it::setJdbcUrl)
        username?.let(it::setUsername)
        password?.let(it::setPassword)

        autoCommit?.let(it::setAutoCommit)
        connectionTimeout?.millis?.let(it::setConnectionTimeout)
        idleTimeout?.millis?.let(it::setIdleTimeout)
        maxLifetime?.millis?.let(it::setMaxLifetime)

        connectionTestQuery?.let(it::setConnectionTestQuery)
        minimumIdle?.let(it::setMinimumIdle)
        maximumPoolSize?.let(it::setMaximumPoolSize)

        metricRegistry?.let(it::setMetricRegistry)
        metricsTrackerFactory?.let(it::setMetricsTrackerFactory)
        healthCheckRegistry?.let(it::setHealthCheckRegistry)

        poolName?.let(it::setPoolName)

        initializationFailTimeout?.millis?.let(it::setInitializationFailTimeout)

        isolateInternalQueries?.let(it::setIsolateInternalQueries)
        allowPoolSuspension?.let(it::setAllowPoolSuspension)
        readOnly?.let(it::setReadOnly)
        registerMbeans?.let(it::setRegisterMbeans)

        catalog?.let(it::setCatalog)
        connectionInitSql?.let(it::setConnectionInitSql)
        driverClassName?.let(it::setDriverClassName)
        transactionIsolation?.let(it::setTransactionIsolation)

        validationTimeout?.millis?.let(it::setValidationTimeout)
        leakDetectionThreshold?.millis?.let(it::setLeakDetectionThreshold)

        schema?.let(it::setSchema)
        threadFactory?.let(it::setThreadFactory)
        scheduledExecutor?.let(it::setScheduledExecutor)
    }
}
