package com.waffel.pokeai.execution;

import com.waffel.pokeai.exceptions.PokeAiException;

import static com.waffel.pokeai.GameConstants.INCOMPLETE_EXCEPTION;

/**
 * The main execution of the application
 */
public class MainExecution implements Execution {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws PokeAiException {
        throw INCOMPLETE_EXCEPTION;
    }

}
