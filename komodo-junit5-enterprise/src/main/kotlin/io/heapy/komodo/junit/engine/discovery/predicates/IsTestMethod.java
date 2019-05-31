/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.heapy.komodo.junit.engine.discovery.predicates;

import org.apiguardian.api.API;
import org.junit.jupiter.api.Test;

import static org.apiguardian.api.API.Status.INTERNAL;

/**
 * Test if a method is a JUnit Jupiter {@link Test @Test} method.
 *
 * @since 5.0
 */
@API(status = INTERNAL, since = "5.0")
public class IsTestMethod extends IsTestableMethod {

	public IsTestMethod() {
		super(Test.class, true);
	}

}
