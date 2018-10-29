package io.heapy.komodo.datasource.hikaricp

import com.zaxxer.hikari.HikariDataSource
import io.heapy.komodo.datasource.DataSourceFactory
import javax.sql.DataSource

/**
 * Provides [HikariDataSource].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class HikariDataSourceFactory(
    private val hikariCPConfiguration: HikariCPConfiguration
) : DataSourceFactory {
    override fun getDataSource(): DataSource {
        return HikariDataSource(hikariCPConfiguration.toHikariConfig())
    }
}
