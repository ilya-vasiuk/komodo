package io.heapy.komodo.datasource.hikaricp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.metrics.MetricsTrackerFactory
import java.time.Duration
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadFactory
import javax.sql.DataSource

/**
 * Represents configuration of HikariCP.
 *
 * HikariCP comes with sane defaults that perform well in most deployments
 * without additional tweaking.
 *
 * Every property is optional, except for the "essentials" marked below.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface HikariCPConfiguration {
    /**
     * **essential**
     *
     * This is the name of the [DataSource] class provided by the JDBC driver.
     * Consult the documentation for your specific JDBC driver to get this
     * class name. Note XA data sources are not supported.
     * XA requires a real transaction manager like bitronix.
     * Note that you do not need this property if you are using [jdbcUrl]
     * for "old-school" DriverManager-based JDBC driver configuration.
     *
     * Default: none
     *
     * [HikariConfig.setDataSourceClassName]
     */
    val dataSourceClassName: String?

    /**
     * **essential**
     *
     * This property directs HikariCP to use "DriverManager-based"
     * configuration. We feel that DataSource-based configuration (above)
     * is superior for a variety of reasons (see below), but for many
     * deployments there is little significant difference. When using this
     * property with "old" drivers, you may also need to set the
     * [driverClassName] property, but try it first without.
     *
     * Note that if this property is used, you may still use
     * [DataSource] properties to configure your driver and is in
     * fact recommended over driver parameters specified in the URL itself.
     *
     * Default: none
     *
     * [HikariConfig.setPassword]
     */
    val jdbcUrl: String?

    /**
     * This property sets the default authentication username used when
     * obtaining Connections from the underlying driver.
     *
     * Note that for DataSources this works in a very deterministic fashion
     * by calling `DataSource.getConnection(*username*, password)` on the
     * underlying [DataSource]. However, for Driver-based configurations,
     * every driver is different. In the case of Driver-based, HikariCP will
     * use this [username] property to set a [user] property in the
     * [java.util.Propertiess] passed to the driver's
     * `DriverManager.getConnection(jdbcUrl, props)` call. If this is not what
     * you need, skip this method entirely and call
     * `addDataSourceProperty("username", ...)`, for example.
     *
     * Default: none
     *
     * [HikariConfig.setUsername]
     */
    val username: String?

    /**
     * This property sets the default authentication password used when
     * obtaining Connections from the underlying driver. Note that for
     * DataSources this works in a very deterministic fashion by calling
     * `DataSource.getConnection(username, *password*)` on the underlying
     * [DataSource]. However, for Driver-based configurations, every driver is
     * different. In the case of Driver-based, HikariCP will use this [password]
     * property to set a `password` property in the [java.util.Properties]
     * passed to the driver's `DriverManager.getConnection(jdbcUrl, props)`
     * call. If this is not what you need, skip this method entirely and
     * call `addDataSourceProperty("pass", ...)`, for example.
     *
     * Default: none
     *
     * [HikariConfig.setPassword]
     */
    val password: String?

    /**
     *  This property is only available via programmatic configuration or IoC
     *  container. This property allows you to directly set the instance of
     *  the DataSource to be wrapped by the pool, rather than having HikariCP
     *  construct it via reflection. This can be useful in some dependency
     *  injection frameworks. When this property is specified, the
     *  dataSourceClassName property and all DataSource-specific properties
     *  will be ignored.
     *
     *  Default: none
     *
     * [HikariConfig.setDataSource]
     */
    val dataSource: DataSource?

    /**
     * This property controls the default auto-commit behavior of connections
     * returned from the pool. It is a boolean value.
     *
     * Default: true
     *
     * [HikariConfig.setAutoCommit]
     */
    val autoCommit: Boolean?

    /**
     * This property controls the maximum number of milliseconds that a client
     * (that's you) will wait for a connection from the pool. If this time is
     * exceeded without a connection becoming available, a SQLException will be
     * thrown. Lowest acceptable connection timeout is 250 ms.
     *
     * Default: 30000 (30 seconds)
     *
     * [HikariConfig.setConnectionTimeout]
     */
    val connectionTimeout: Duration?

    /**
     * This property controls the maximum amount of time that a connection is
     * allowed to sit idle in the pool. **This setting only applies when
     * [minimumIdle] is defined to be less than [maximumPoolSize]**. Idle
     * connections will not be retired once the pool reaches [minimumIdle]
     * connections. Whether a connection is retired as idle or not is subject
     * to a maximum variation of +30 seconds, and average variation of +15
     * seconds. A connection will never be retired as idle before this
     * timeout. A value of `0` means that idle connections are never removed
     * from the pool. The minimum allowed value is 10000ms (10 seconds).
     *
     * Default: 600000 (10 minutes)
     *
     * [HikariConfig.setIdleTimeout]
     */
    val idleTimeout: Duration?

    /**
     * This property controls the maximum lifetime of a connection in the
     * pool. An in-use connection will never be retired, only when it is
     * closed will it then be removed. On a connection-by-connection basis,
     * minor negative attenuation is applied to avoid mass-extinction in
     * the pool. **We strongly recommend setting this value, and it should be
     * several seconds shorter than any database or infrastructure imposed
     * connection time limit**. A value of 0 indicates no maximum lifetime
     * (infinite lifetime), subject of course to the [idleTimeout] setting.
     *
     * Default: 1800000 (30 minutes)
     *
     * [HikariConfig.setMaxLifetime]
     */
    val maxLifetime: Duration?

    /**
     * **If your driver supports JDBC4 we strongly recommend not setting this
     * property**. This is for "legacy" drivers that do not support the JDBC4
     * `Connection.isValid()` API. This is the query that will be executed
     * just before a connection is given to you from the pool to validate that
     * the connection to the database is still alive. Again, try running the
     * pool without this property, HikariCP will log an error if your driver
     * is not JDBC4 compliant to let you know.
     *
     * Default: none
     *
     * [HikariConfig.setConnectionTestQuery]
     */
    val connectionTestQuery: String?

    /**
     * This property controls the minimum number of idle connections that
     * HikariCP tries to maintain in the pool. If the idle connections dip
     * below this value and total connections in the pool are less than
     * maximumPoolSize, HikariCP will make a best effort to add additional
     * connections quickly and efficiently. However, for maximum performance
     * and responsiveness to spike demands, we recommend not setting this
     * value and instead allowing HikariCP to act as a fixed size connection
     * pool.
     *
     * Default: same as [maximumPoolSize]
     *
     * [HikariConfig.setMinimumIdle]
     */
    val minimumIdle: Int?

    /**
     * This property controls the maximum size that the pool is allowed to
     * reach, including both idle and in-use connections. Basically this value
     * will determine the maximum number of actual connections to the database
     * backend. A reasonable value for this is best determined by your
     * execution environment. When the pool reaches this size, and no idle
     * connections are available, calls to getConnection() will block for up
     * to [connectionTimeout] milliseconds before timing out. Please read
     * [about pool sizing](https://github.com/brettwooldridge/HikariCP/wiki/About-Pool-Sizing).
     *
     * Default: 10
     *
     * [HikariConfig.setMaximumPoolSize]
     */
    val maximumPoolSize: Int?

    /**
     * This property is only available via programmatic configuration or IoC
     * container. This property allows you to specify an instance of a
     * Codahale/Dropwizard `MetricRegistry` to be used by the pool to record
     * various metrics. See the
     * [Metrics](https://github.com/brettwooldridge/HikariCP/wiki/Dropwizard-Metrics)
     * wiki page for details.
     *
     * Default: none
     *
     * [HikariConfig.setMetricRegistry]
     */
    val metricRegistry: Any?


    val metricsTrackerFactory: MetricsTrackerFactory?
    val healthCheckRegistry: Any?

    val poolName: String?

    val initializationFailTimeout: Duration?

    val isolateInternalQueries: Boolean?
    val allowPoolSuspension: Boolean?
    val readOnly: Boolean?
    val registerMbeans: Boolean?

    val catalog: String?
    val connectionInitSql: String?
    val driverClassName: String?
    val transactionIsolation: String?

    val validationTimeout: Duration?
    val leakDetectionThreshold: Duration?

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
        connectionTimeout?.toMillis()?.let(it::setConnectionTimeout)
        idleTimeout?.toMillis()?.let(it::setIdleTimeout)
        maxLifetime?.toMillis()?.let(it::setMaxLifetime)

        connectionTestQuery?.let(it::setConnectionTestQuery)
        minimumIdle?.let(it::setMinimumIdle)
        maximumPoolSize?.let(it::setMaximumPoolSize)

        metricRegistry?.let(it::setMetricRegistry)
        metricsTrackerFactory?.let(it::setMetricsTrackerFactory)
        healthCheckRegistry?.let(it::setHealthCheckRegistry)

        poolName?.let(it::setPoolName)

        initializationFailTimeout?.toMillis()?.let(it::setInitializationFailTimeout)

        isolateInternalQueries?.let(it::setIsolateInternalQueries)
        allowPoolSuspension?.let(it::setAllowPoolSuspension)
        readOnly?.let(it::setReadOnly)
        registerMbeans?.let(it::setRegisterMbeans)

        catalog?.let(it::setCatalog)
        connectionInitSql?.let(it::setConnectionInitSql)
        driverClassName?.let(it::setDriverClassName)
        transactionIsolation?.let(it::setTransactionIsolation)

        validationTimeout?.toMillis()?.let(it::setValidationTimeout)
        leakDetectionThreshold?.toMillis()?.let(it::setLeakDetectionThreshold)

        schema?.let(it::setSchema)
        threadFactory?.let(it::setThreadFactory)
        scheduledExecutor?.let(it::setScheduledExecutor)
    }
}
