/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.heapy.komodo.junit.engine.discovery;

import io.heapy.komodo.junit.engine.config.JupiterConfiguration;
import io.heapy.komodo.junit.engine.descriptor.TestMethodTestDescriptor;
import io.heapy.komodo.junit.engine.discovery.predicates.IsTestMethod;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

import java.lang.reflect.Method;
import java.util.function.Predicate;

/**
 * {@code TestMethodResolver} is an {@link ElementResolver} that is able to
 * resolve methods annotated with {@link Test @Test}.
 *
 * <p>It creates {@link TestMethodTestDescriptor} instances.
 *
 * @since 5.0
 * @see ElementResolver
 * @see Test
 * @see TestMethodTestDescriptor
 */
class TestMethodResolver extends AbstractMethodResolver {

	private static final Predicate<Method> isTestMethod = new IsTestMethod();

	static final String SEGMENT_TYPE = "method";

	TestMethodResolver(JupiterConfiguration configuration) {
		super(SEGMENT_TYPE, isTestMethod, configuration);
	}

	@Override
	protected TestDescriptor createTestDescriptor(UniqueId uniqueId, Class<?> testClass, Method method,
			JupiterConfiguration configuration) {
		return new TestMethodTestDescriptor(uniqueId, testClass, method, configuration);
	}

}
