package by.heap.komodo.context

import by.heap.komodo.Provider
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.kotlin.utils.keysToMap
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmErasure
import kotlin.reflect.jvm.reflect

/**
 * Generic implementation of Beans.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
class DefaultBeans : Beans {
    private val beanDefinitions = mutableMapOf<KClass<*>, BeanDefinition<*>>()

    private val createdBeans = mutableMapOf<KClass<*>, Any>()

    override fun start() {
        println("Sir, yes sir!")
    }

    suspend override fun <T : Any> get(kclass: KClass<T>): T {
        return getOrCreateBean(kclass)
    }

    suspend private fun <T : Any> getOrCreateBean(kclass: KClass<T>): T {
        val bean = createdBeans[kclass]

        if (bean != null) {
            return bean as T
        } else {
            val definition = getBeanDefinition(kclass)

            val created = create(definition)
            createdBeans.put(kclass, created)
            return created as T
        }
    }

    override fun <T : Any> getSet(kclass: KClass<T>): Set<T> {
        TODO()
    }

    override fun register(kclass: KClass<*>): Beans {
        this.beanDefinitions.put(kclass, beanDefinition(kclass))
        return this
    }

    override fun registerProvider(kclass: KClass<*>, provider: Function<*>): Beans {
        val constructor = provider.reflect() ?: throw RuntimeException("Can't introspect provider: $provider.")
        this.beanDefinitions.put(kclass, BeanDefinition(kclass, constructor))
        return this
    }

    override fun registerProvider(kclass: KClass<*>, provider: KClass<out Provider<*>>): Beans {
        val constructor = getConstructor(provider)
        val bd = BeanDefinition(kclass, constructor)

        this.beanDefinitions.put(kclass, bd)
        return this
    }

    suspend private fun <T : Any> create(beanDefinition: BeanDefinition<T>): T {
        val params = beanDefinition.constructor.parameters

        val obj = try {
            if (params.isEmpty()) {
                beanDefinition.constructor.call()
            } else {
                // TODO: Fix this part
                val paramsToInstance = params.keysToMap { runBlocking { create(getBeanDefinition(it.type.jvmErasure)) } }

                beanDefinition.constructor.callBy(paramsToInstance)
            }
        } catch (e: Exception) {
            throw e
        }

        return if (obj is Provider<*>) {
            obj.getInstance() as T
        } else {
            obj as T
        }
    }

    private fun getBeanDefinition(kclass: KClass<*>): BeanDefinition<*> {
        val definition: BeanDefinition<*>? = beanDefinitions[kclass]

        if (definition != null) {
            return definition
        } else {
            throw RuntimeException("No definition found for ${kclass.qualifiedName}.")
        }
    }

}

private fun beanDefinition(klass: KClass<*>): BeanDefinition<*> {
    val constructor = getConstructor(klass)
    return BeanDefinition(klass, constructor)
}

private fun getConstructor(klass: KClass<*>): KFunction<*> {
    val constructor = klass.constructors.singleOrNull()
    return constructor ?: throw RuntimeException("Expected single constructor for type ${klass.qualifiedName}")
}

class Bean1 {
    fun foo() {
        println("bean1")
    }
}

class Bean2(val bean1: Bean1) {
    fun boo() {
        println("bean2")
        bean1.foo()
    }
}

class Bean3(val bean2: Bean2) {
    fun bark() {
        println("bean3")
        bean2.boo()
    }
}

class Bean4(val bean3: Bean3, val bean2: Bean2) {
    fun bar() {
        println("bean4")
        bean2.boo()
        bean3.bark()
    }
}

class Bean4Provider(val bean3: Bean3, val bean2: Bean2) : Provider<Bean4> {
    suspend override fun getInstance() = Bean4(bean3, bean2)
}

fun main(args: Array<String>) {
    val beans = DefaultBeans().apply {
        register(Bean1::class)
        register(Bean2::class)
        register(Bean3::class)


        registerProvider(Bean4::class, Bean4Provider::class)
        start()
    }

    runBlocking {
        beans.get(Bean4::class).bar()
    }

}
