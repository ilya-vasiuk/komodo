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

import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;
import java.util.Set;

/**
 * @since 5.0
 */
interface ElementResolver {

	/**
	 * Return a set of {@link TestDescriptor TestDescriptors} that can be
	 * resolved by this resolver.
	 *
	 * <p>Returned set must be empty if {@code element} cannot be resolved.
	 */
	Set<TestDescriptor> resolveElement(AnnotatedElement element, TestDescriptor parent);

	/**
	 * Return an optional {@link TestDescriptor}.
	 *
	 * <p>Return {@code Optional.empty()} if {@code segment} cannot be resolved.
	 */
	Optional<TestDescriptor> resolveUniqueId(UniqueId.Segment segment, TestDescriptor parent);

}
