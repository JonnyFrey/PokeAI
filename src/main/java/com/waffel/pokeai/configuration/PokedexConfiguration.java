package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.SlickExecution;
import com.waffel.pokeai.modules.PokemonModule;

import java.util.Collections;
import java.util.List;

/**
 * Configuration required for the Creating a Pokedex
 */
public class PokedexConfiguration implements Configuration<SlickExecution> {

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
        return Collections.singletonList(new PokemonModule());
    }
}
