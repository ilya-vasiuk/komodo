package io.heapy.komodo.junit.engine

import io.heapy.logging.logger
import org.junit.platform.engine.EngineDiscoveryRequest
import org.junit.platform.engine.ExecutionRequest
import org.junit.platform.engine.TestDescriptor
import org.junit.platform.engine.TestEngine
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.engine.TestSource
import org.junit.platform.engine.TestTag
import org.junit.platform.engine.UniqueId
import org.junit.platform.engine.discovery.ClassSelector
import org.junit.platform.engine.support.descriptor.ClassSource
import org.junit.platform.engine.support.descriptor.EngineDescriptor
import java.util.Optional
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.declaredFunctions

/**
 * Test Engine for running suspend tests.
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
class KotlinCoroutinesTestEngine : TestEngine {
    init {
        LOGGER.info("KotlinCoroutinesTestEngine created")
    }

    override fun execute(request: ExecutionRequest) {
        val engine = request.rootTestDescriptor
        val listener = request.engineExecutionListener
        listener.executionStarted(engine)

        for (testClass in engine.children) {
            listener.executionStarted(testClass)
            for (testMethod in testClass.children) {
                listener.executionStarted(testMethod)
                val result = executeDirect(testMethod as SuspendMethod)
                listener.executionFinished(testMethod, result)
            }
            listener.executionFinished(testClass, TestExecutionResult.successful())
        }
        listener.executionFinished(engine, TestExecutionResult.successful())
    }

    private fun executeDirect(suspendMethod: SuspendMethod): TestExecutionResult {
        try {

        } catch (t: Throwable) {
            return TestExecutionResult.failed(t)
        }

        return TestExecutionResult.successful()
    }

    override fun getId() = TEST_ENGINE_ID

    override fun discover(discoveryRequest: EngineDiscoveryRequest, uniqueId: UniqueId): TestDescriptor {
        SuspendMethod(uniqueId)
        return discoveryRequest.getSelectorsByType(ClassSelector::class.java)
            .map { selector ->
                selector to selector.javaClass.kotlin.declaredFunctions.filter { func -> func.isSuspend }
            }
            .map { CoroutinesTestDescriptor(clazz = it.first.javaClass.kotlin, methods = it.second) }
            .single()
    }

    companion object {
        private val LOGGER = logger<KotlinCoroutinesTestEngine>()
    }
}

const val TEST_ENGINE_ID = "KotlinCoroutines"

class SuspendMethod(uniqueId: UniqueId) : EngineDescriptor(uniqueId, "Kotlin Coroutines Engine")

class CoroutinesTestDescriptor(
    val clazz: KClass<*>,
    val methods: List<KFunction<*>>
) : TestDescriptor {
    override fun getSource(): Optional<TestSource> = Optional.of(ClassSource.from(clazz.java))

    override fun removeFromHierarchy() {
    }

    override fun setParent(parent: TestDescriptor) {
    }

    override fun getParent(): Optional<TestDescriptor> {
        return Optional.empty()
    }

    override fun getChildren(): MutableSet<out TestDescriptor> {
        return mutableSetOf()
    }

    override fun getDisplayName(): String {
        return clazz.simpleName!!
    }

    override fun getType(): TestDescriptor.Type {
        return TestDescriptor.Type.CONTAINER
    }

    override fun getUniqueId(): UniqueId {
        return UniqueId.forEngine(TEST_ENGINE_ID)
    }

    override fun removeChild(descriptor: TestDescriptor?) {
    }

    override fun addChild(descriptor: TestDescriptor?) {
    }

    override fun findByUniqueId(uniqueId: UniqueId?): Optional<out TestDescriptor> {
        return Optional.empty()
    }

    override fun getTags(): MutableSet<TestTag> {
        return mutableSetOf()
    }

}
