package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.PokedexExecution;
import com.waffel.pokeai.modules.PokemonModule;

import java.util.Collections;
import java.util.List;

/**
 * Configuration required for the {@link PokedexExecution}
 */
public class PokedexConfiguration implements Configuration<PokedexExecution> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<PokedexExecution> getExecution() {
        return PokedexExecution.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Module> getRequiredModules() {
        return Collections.singletonList(new PokemonModule());
    }
}
