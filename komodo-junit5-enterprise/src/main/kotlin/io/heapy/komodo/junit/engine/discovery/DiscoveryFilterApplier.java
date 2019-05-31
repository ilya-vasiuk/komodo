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

import io.heapy.komodo.junit.engine.descriptor.ClassTestDescriptor;
import io.heapy.komodo.junit.engine.descriptor.NestedClassTestDescriptor;
import org.junit.platform.engine.TestDescriptor;

import java.util.function.Predicate;

/**
 * Class for applying filters to all children of a {@link TestDescriptor}.
 *
 * @since 5.0
 */
class DiscoveryFilterApplier {

	void applyClassNamePredicate(Predicate<String> classNamePredicate, TestDescriptor engineDescriptor) {
		TestDescriptor.Visitor filteringVisitor = descriptor -> {
			if (descriptor instanceof ClassTestDescriptor
					&& !includeClass((ClassTestDescriptor) descriptor, classNamePredicate)) {
				descriptor.removeFromHierarchy();
			}
		};
		engineDescriptor.accept(filteringVisitor);
	}

	private boolean includeClass(ClassTestDescriptor classTestDescriptor, Predicate<String> classNamePredicate) {

		// Nested Tests are never filtered out
		if (classTestDescriptor instanceof NestedClassTestDescriptor) {
			return true;
		}

		return classNamePredicate.test(classTestDescriptor.getTestClass().getName());
	}

}
