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
import io.heapy.komodo.junit.engine.execution.JupiterEngineExecutionContext;
import io.heapy.komodo.junit.engine.extension.ExtensionRegistry;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

import static io.heapy.komodo.junit.engine.descriptor.JupiterTestDescriptor.toExecutionMode;
import static io.heapy.komodo.junit.engine.extension.ExtensionRegistry.createRegistryWithDefaultExtensions;
import static org.apiguardian.api.API.Status.INTERNAL;

/**
 * @since 5.0
 */
@API(status = INTERNAL, since = "5.0")
public class EnterpriseEngineDescriptor extends EngineDescriptor implements Node<JupiterEngineExecutionContext> {

    public static final String ENGINE_ID = "komodo-enterprise";
    private final JupiterConfiguration configuration;

    public EnterpriseEngineDescriptor(UniqueId uniqueId, JupiterConfiguration configuration) {
        super(uniqueId, "Komodo Enterprise");
        this.configuration = configuration;
    }

    public JupiterConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public ExecutionMode getExecutionMode() {
        return toExecutionMode(configuration.getDefaultExecutionMode());
    }

    @Override
    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext context) {
        ExtensionRegistry extensionRegistry = createRegistryWithDefaultExtensions(context.getConfiguration());
        EngineExecutionListener executionListener = context.getExecutionListener();
        ExtensionContext extensionContext = new JupiterEngineExtensionContext(executionListener, this,
                context.getConfiguration());

        // @formatter:off
        return context.extend()
                .withExtensionRegistry(extensionRegistry)
                .withExtensionContext(extensionContext)
                .build();
        // @formatter:on
    }

    @Override
    public void cleanUp(JupiterEngineExecutionContext context) throws Exception {
        context.close();
    }

}
