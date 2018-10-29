package io.heapy.komodo.datasource.hikaricp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.metrics.MetricsTrackerFactory
import io.heapy.komodo.core.beans.setIfNotNull
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
        setIfNotNull(it::setDataSource, dataSource)
        setIfNotNull(it::setDataSourceClassName, dataSourceClassName)
        setIfNotNull(it::setJdbcUrl, jdbcUrl)
        setIfNotNull(it::setUsername, username)
        setIfNotNull(it::setPassword, password)

        setIfNotNull(it::setAutoCommit, autoCommit)
        setIfNotNull(it::setConnectionTimeout, connectionTimeout?.millis)
        setIfNotNull(it::setIdleTimeout, idleTimeout?.millis)
        setIfNotNull(it::setMaxLifetime, maxLifetime?.millis)

        setIfNotNull(it::setConnectionTestQuery, connectionTestQuery)
        setIfNotNull(it::setMinimumIdle, minimumIdle)
        setIfNotNull(it::setMaximumPoolSize, maximumPoolSize)

        setIfNotNull(it::setMetricRegistry, metricRegistry)
        setIfNotNull(it::setMetricsTrackerFactory, metricsTrackerFactory)
        setIfNotNull(it::setHealthCheckRegistry, healthCheckRegistry)

        setIfNotNull(it::setPoolName, poolName)

        setIfNotNull(it::setInitializationFailTimeout, initializationFailTimeout?.millis)

        setIfNotNull(it::setIsolateInternalQueries, isolateInternalQueries)
        setIfNotNull(it::setAllowPoolSuspension, allowPoolSuspension)
        setIfNotNull(it::setReadOnly, readOnly)
        setIfNotNull(it::setRegisterMbeans, registerMbeans)

        setIfNotNull(it::setCatalog, catalog)
        setIfNotNull(it::setConnectionInitSql, connectionInitSql)
        setIfNotNull(it::setDriverClassName, driverClassName)
        setIfNotNull(it::setTransactionIsolation, transactionIsolation)

        setIfNotNull(it::setValidationTimeout, validationTimeout?.millis)
        setIfNotNull(it::setLeakDetectionThreshold, leakDetectionThreshold?.millis)

        setIfNotNull(it::setSchema, schema)
        setIfNotNull(it::setThreadFactory, threadFactory)
        setIfNotNull(it::setScheduledExecutor, scheduledExecutor)
    }
}
