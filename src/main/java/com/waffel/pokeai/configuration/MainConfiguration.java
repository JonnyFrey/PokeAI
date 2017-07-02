package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.MainExecution;

import java.util.List;

import static com.waffel.pokeai.GameConstants.INCOMPLETE_EXCEPTION;

/**
 * Configuration required for the {@link MainExecution}
 */
public class MainConfiguration implements Configuration<MainExecution> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<MainExecution> getExecution() {
        throw INCOMPLETE_EXCEPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Module> getRequiredModules() {
        throw INCOMPLETE_EXCEPTION;
    }
}
