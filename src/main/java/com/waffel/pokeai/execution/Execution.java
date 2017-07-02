package com.waffel.pokeai.execution;

import com.waffel.pokeai.exceptions.PokeAiException;

/**
 * Represents an executable bit of code.
 */
@FunctionalInterface
public interface Execution {

    /**
     * The execution entry point
     *
     * @throws PokeAiException if there is an issue with running the method
     */
    void execute() throws PokeAiException;

}
