package io.heapy.komodo.di.default

import io.mockk.every
import io.mockk.mockkConstructor
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

interface Constructor0
interface Constructor1<in T1>
interface Constructor2<in T1, in T2>
interface Constructor3<in T1, in T2, in T3>
interface Constructor4<in T1, in T2, in T3, in T4>

class BeanConstructionException(
    name: String
) : RuntimeException("Primary constructor not found for class $name.")

class Creator2<out T : Any, in T1, in T2>(
    private val klass: KClass<T>,
    private val args: Array<Any?>
) : Constructor2<T1, T2> {
    fun inject(t2: T2): Creator1<T, T1> {
        args[1] = t2
        return Creator1(klass, args)
    }
}

class Creator1<out T : Any, in T1>(
    private val klass: KClass<T>,
    private val args: Array<Any?>
) {
    fun inject(t1: T1): Creator0<T> {
        args[0] = t1
        return Creator0(klass, args)
    }

    operator fun invoke(t1: T1): Creator0<T> {
        args[0] = t1
        return Creator0(klass, args)
    }
}

class Creator0<out T : Any>(
    private val klass: KClass<T>,
    private val args: Array<Any?> = emptyArray()
) : Constructor0 {
    fun new(): T {
        return (klass.primaryConstructor ?: throw BeanConstructionException(klass.qualifiedName ?: "Unknown")).call(*args)
    }

    operator fun invoke(): T {
        return (klass.primaryConstructor ?: throw BeanConstructionException(klass.qualifiedName ?: "Unknown")).call(*args)
    }
}

inline fun <T1, reified T : Any> ((T1) -> T).inject(t1: T1): Creator0<T> {
    val args = arrayOfNulls<Any>(1)
    args[0] = t1
    return Creator0(T::class, args)
}

inline fun <T1, T2, reified T : Any> ((T1, T2) -> T).inject(t2: T2): Creator1<T, T1> {
    val args = arrayOfNulls<Any>(2)
    args[1] = t2
    return Creator1(T::class, args)
}

operator inline fun <T1, T2, reified T : Any> ((T1, T2) -> T).invoke(t2: T2): Creator1<T, T1> {
    val args = arrayOfNulls<Any>(2)
    args[1] = t2
    return Creator1(T::class, args)
}

inline fun <T1, T2 : Any, reified T : Any> ((T1, T2) -> T).inject(t2: KClass<out T2>): Creator1<T, T1> {
    val args = arrayOfNulls<Any>(2)
    args[1] = t2
    return Creator1(T::class, args)
}

inline fun <reified  T1, reified  T2, reified T3, reified T : Any> ((T1, T2, T3) -> T).inject(t3: T3): Creator2<T, T1, T2> {
    val args = arrayOfNulls<Any>(3)
    args[2] = t3
    return Creator2(T::class, args)
}

class Bean2(
    private val a: String,
    private val b: Int
) {
    fun run() {
        println(a + b)
    }
}

class Bean3(
    private val bean2: Bean2
) {
    fun run() {
        print("Bean 3! ")
        bean2.run()
    }
}

fun main(args: Array<String>) {
    ::Bean2.inject(Int::class)

    (::Bean2)(42)("Hello ")().run()

    ::Bean3
        .inject(
            ::Bean2
                .inject(42)
                .inject("Hello ")
                .new()
        )
        .new()
        .run()

    class MockCls {
        fun add(a: Int, b: Int) = a + b
    }

    mockkConstructor(MockCls::class)

    every { anyConstructed<MockCls>().add(1, 2) } returns 4

    assertEquals(4, MockCls().add(1, 2)) // note new object is created

    verify { anyConstructed<MockCls>().add(1, 2) }
}
