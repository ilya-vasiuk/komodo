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

import io.heapy.komodo.junit.engine.descriptor.MethodBasedTestDescriptor;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of {@link MethodDescriptor}, backed by
 * a {@link MethodBasedTestDescriptor}.
 *
 * @since 5.4
 */
class DefaultMethodDescriptor implements MethodDescriptor {

	private final MethodBasedTestDescriptor testDescriptor;

	DefaultMethodDescriptor(MethodBasedTestDescriptor testDescriptor) {
		this.testDescriptor = testDescriptor;
	}

	MethodBasedTestDescriptor getTestDescriptor() {
		return testDescriptor;
	}

	@Override
	public final Method getMethod() {
		return this.testDescriptor.getTestMethod();
	}

	@Override
	public boolean isAnnotated(Class<? extends Annotation> annotationType) {
		Preconditions.notNull(annotationType, "annotationType must not be null");
		return AnnotationUtils.isAnnotated(getMethod(), annotationType);
	}

	@Override
	public <A extends Annotation> Optional<A> findAnnotation(Class<A> annotationType) {
		Preconditions.notNull(annotationType, "annotationType must not be null");
		return AnnotationUtils.findAnnotation(getMethod(), annotationType);
	}

	@Override
	public <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> annotationType) {
		Preconditions.notNull(annotationType, "annotationType must not be null");
		return AnnotationUtils.findRepeatableAnnotations(getMethod(), annotationType);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("method", getMethod().toGenericString()).toString();
	}

}
