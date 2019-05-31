package io.heapy.komodo.junit.engine.execution

import kotlinx.coroutines.runBlocking
import org.junit.platform.commons.util.ExceptionUtils
import org.junit.platform.commons.util.Preconditions
import org.junit.platform.commons.util.ReflectionUtils.isStatic
import org.junit.platform.commons.util.ReflectionUtils.makeAccessible
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import kotlin.reflect.full.callSuspend
import kotlin.reflect.jvm.kotlinFunction

/**
 * TODO.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
/**
 * @see org.junit.platform.commons.support.ReflectionSupport.invokeMethod
 */
fun invokeMethod(method: Method, target: Any?, vararg args: Any): Any? {
    Preconditions.notNull(method, "Method must not be null")
    Preconditions.condition(target != null || isStatic(method)
    ) { String.format("Cannot invoke non-static method [%s] on a null target.", method.toGenericString()) }

    try {
        return runBlocking {
            makeAccessible(method).kotlinFunction?.callSuspend(target, *args.dropLast(1).toTypedArray())
        }
    } catch (t: Throwable) {
        throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(t))
    }
}

private fun getUnderlyingCause(t: Throwable): Throwable {
    return if (t is InvocationTargetException) {
        getUnderlyingCause(t.targetException)
    } else t
}
