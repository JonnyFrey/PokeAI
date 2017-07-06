package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.SlickExecution;

import java.util.List;

import static com.waffel.pokeai.GameConstants.INCOMPLETE_EXCEPTION;

public class MainConfiguration implements Configuration<SlickExecution> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<SlickExecution> getExecution() {
        return SlickExecution.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Module> getRequiredModules() {
        throw INCOMPLETE_EXCEPTION;
    }
}
