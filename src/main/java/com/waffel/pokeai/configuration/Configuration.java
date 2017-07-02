package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.Execution;

import java.util.List;

/**
 * Represents all the information that is required to build/use the associated execution
 */
public interface Configuration<T extends Execution> {

    /**
     * The {@link Execution} class that this configuration is created for.
     *
     * @return the {@link Execution} class
     */
    public Class<T> getExecution();

    /**
     * A list modules that is required to create and use a {@link Execution}
     *
     * @return the modules
     */
    public List<Module> getRequiredModules();

}
