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

import io.heapy.komodo.junit.engine.config.JupiterConfiguration;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.platform.engine.EngineExecutionListener;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @since 5.0
 */
final class JupiterEngineExtensionContext extends AbstractExtensionContext<EnterpriseEngineDescriptor> {

	JupiterEngineExtensionContext(EngineExecutionListener engineExecutionListener,
								  EnterpriseEngineDescriptor testDescriptor, JupiterConfiguration configuration) {

		super(null, engineExecutionListener, testDescriptor, configuration);
	}

	@Override
	public Optional<AnnotatedElement> getElement() {
		return Optional.empty();
	}

	@Override
	public Optional<Class<?>> getTestClass() {
		return Optional.empty();
	}

	@Override
	public Optional<Lifecycle> getTestInstanceLifecycle() {
		return Optional.empty();
	}

	@Override
	public Optional<Object> getTestInstance() {
		return Optional.empty();
	}

	@Override
	public Optional<TestInstances> getTestInstances() {
		return Optional.empty();
	}

	@Override
	public Optional<Method> getTestMethod() {
		return Optional.empty();
	}

	@Override
	public Optional<Throwable> getExecutionException() {
		return Optional.empty();
	}

}
