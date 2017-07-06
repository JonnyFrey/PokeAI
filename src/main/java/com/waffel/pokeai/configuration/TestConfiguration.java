package com.waffel.pokeai.configuration;

import com.beust.jcommander.Parameter;
import com.google.inject.Module;
import com.waffel.pokeai.GameConstants;
import com.waffel.pokeai.execution.SlickExecution;
import com.waffel.pokeai.games.TestSlickGame;
import com.waffel.pokeai.modules.SlickModule;

import java.util.Collections;
import java.util.List;

/**
 * Configuration required for the {@link SlickExecution}
 */
public class TestConfiguration implements Configuration<SlickExecution> {

    /**
     * The parameter to set the title of the application.
     */
    @Parameter(names = {"--title", "-t"}, description = "Sets the title of the test game")
    private String gameTitle = "Test Game";

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
        return Collections.singletonList(
                new SlickModule<>(
                        this.gameTitle,
                        TestSlickGame.class,
                        GameConstants.TEST_GAME_WIDTH,
                        GameConstants.TEST_GAME_HEIGHT
                ));
    }
}
