package io.heapy.komodo.datasource

import javax.sql.DataSource

/**
 * [DataSourceFactory] provides [DataSource].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface DataSourceFactory {
    fun getDataSource(): DataSource
}
