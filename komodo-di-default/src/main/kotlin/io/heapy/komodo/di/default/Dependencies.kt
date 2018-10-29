package io.heapy.komodo.di.default

import io.heapy.komodo.di.Module
import io.heapy.komodo.di.Provider
import kotlin.reflect.KClass

/**
 * Represents an dependency in binder.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
sealed class Dependency<T : Any>(
    val key: KClass<T>
)

class DependencyOverride<T : Any>(
    key: KClass<T>,
    val moduleKlass: KClass<out Module>,
    val dependency: Dependency<T>
) : Dependency<T>(key)

class DependencySet<T : Any>(
    key: KClass<T>,
    val dependencies: Set<Dependency<T>>
) : Dependency<T>(key)

class ImplDependency<T : Any>(
    key: KClass<T>,
    val impl: T
) : Dependency<T>(key)

class ProviderDependency<T : Any>(
    key: KClass<T>,
    val provider: KClass<out Provider<T>>
) : Dependency<T>(key)

class ClassDependency<T : Any>(
    key: KClass<T>,
    val clazz: KClass<out T>
) : Dependency<T>(key)

class WrappedImplDependency<T : Any>(
    key: KClass<T>,
    val impl: T,
    val dependency: Dependency<T>
) : Dependency<T>(key)

class WrappedProviderDependency<T : Any>(
    key: KClass<T>,
    val provider: KClass<out Provider<T>>,
    val dependency: Dependency<T>
) : Dependency<T>(key)

class WrappedClassDependency<T : Any>(
    key: KClass<T>,
    val clazz: KClass<out T>,
    val dependency: Dependency<T>
) : Dependency<T>(key)
