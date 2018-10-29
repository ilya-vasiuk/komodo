package io.heapy.integration.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Function to retrieve logger by class.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
inline fun <reified T : Any> logger(): Logger = LoggerFactory.getLogger(T::class.java)
