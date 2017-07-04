package com.waffel.pokeai.execution;

import com.waffel.pokeai.dex.PokeDex;
import com.waffel.pokeai.exceptions.PokeAiException;

import javax.inject.Inject;

/**
 * An executable that runs the pokedex so that we can inspect pokemon
 */

public class PokedexExecution implements Execution {

    private final PokeDex pokeDex;

    @Inject
    public PokedexExecution(PokeDex pokeDex) {
        this.pokeDex = pokeDex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws PokeAiException {
        System.out.println(pokeDex.getRandomPokemon());
    }
}
