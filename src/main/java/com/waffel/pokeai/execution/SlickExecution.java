package com.waffel.pokeai.execution;

import com.waffel.pokeai.exceptions.PokeAiException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import javax.inject.Inject;

/**
 * An executable to run a test game for verifying slick2D installation.
 */
public class SlickExecution implements Execution {

    /**
     * The container to execute
     */
    private final AppGameContainer container;

    /**
     * Runs an {@link AppGameContainer} that is supplied
     *
     * @param container test container to run with
     */
    @Inject
    public SlickExecution(final AppGameContainer container) {
        this.container = container;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws PokeAiException {
        try {
            container.start();
        } catch (final SlickException e) {
            throw new PokeAiException("Failed to start and execute Slick2D container", e);
        }
    }
}
