/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.heapy.komodo.junit.engine.execution;

import io.heapy.komodo.junit.engine.extension.ExtensionRegistry;
import org.apiguardian.api.API;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.apiguardian.api.API.Status.INTERNAL;

/**
 * Functional interface for registering an {@link AfterEach @AfterEach} method
 * as a pseudo-extension.
 *
 * @since 5.0
 */
@FunctionalInterface
@API(status = INTERNAL, since = "5.0")
public interface AfterEachMethodAdapter extends Extension {

	void invokeAfterEachMethod(ExtensionContext context, ExtensionRegistry registry) throws Throwable;

}
