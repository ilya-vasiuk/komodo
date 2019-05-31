/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.heapy.komodo.junit.engine.descriptor;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import io.heapy.komodo.junit.engine.config.JupiterConfiguration;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

/**
 * @since 5.0
 */
final class ClassExtensionContext extends AbstractExtensionContext<ClassTestDescriptor> {

	private final Lifecycle lifecycle;

	private final ThrowableCollector throwableCollector;

	private TestInstances testInstances;

	/**
	 * Create a new {@code ClassExtensionContext} with {@link Lifecycle#PER_METHOD}.
	 *
	 * @see #ClassExtensionContext(ExtensionContext, EngineExecutionListener, ClassTestDescriptor, Lifecycle, JupiterConfiguration, ThrowableCollector)
	 */
	ClassExtensionContext(ExtensionContext parent, EngineExecutionListener engineExecutionListener,
			ClassTestDescriptor testDescriptor, JupiterConfiguration configuration,
			ThrowableCollector throwableCollector) {

		this(parent, engineExecutionListener, testDescriptor, Lifecycle.PER_METHOD, configuration, throwableCollector);
	}

	ClassExtensionContext(ExtensionContext parent, EngineExecutionListener engineExecutionListener,
			ClassTestDescriptor testDescriptor, Lifecycle lifecycle, JupiterConfiguration configuration,
			ThrowableCollector throwableCollector) {

		super(parent, engineExecutionListener, testDescriptor, configuration);

		this.lifecycle = lifecycle;
		this.throwableCollector = throwableCollector;
	}

	@Override
	public Optional<AnnotatedElement> getElement() {
		return Optional.of(getTestDescriptor().getTestClass());
	}

	@Override
	public Optional<Class<?>> getTestClass() {
		return Optional.of(getTestDescriptor().getTestClass());
	}

	@Override
	public Optional<Lifecycle> getTestInstanceLifecycle() {
		return Optional.of(this.lifecycle);
	}

	@Override
	public Optional<Object> getTestInstance() {
		return getTestInstances().map(TestInstances::getInnermostInstance);
	}

	@Override
	public Optional<TestInstances> getTestInstances() {
		return Optional.ofNullable(testInstances);
	}

	void setTestInstances(TestInstances testInstances) {
		this.testInstances = testInstances;
	}

	@Override
	public Optional<Method> getTestMethod() {
		return Optional.empty();
	}

	@Override
	public Optional<Throwable> getExecutionException() {
		return Optional.ofNullable(this.throwableCollector.getThrowable());
	}

}
