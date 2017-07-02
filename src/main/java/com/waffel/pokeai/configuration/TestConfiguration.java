package com.waffel.pokeai.configuration;

import com.beust.jcommander.Parameter;
import com.google.inject.Module;
import com.waffel.pokeai.execution.TestExecution;
import com.waffel.pokeai.modules.TestSlickModule;

import java.util.Collections;
import java.util.List;

/**
 * Configuration required for the {@link TestExecution}
 */
public class TestConfiguration implements Configuration<TestExecution> {

    /**
     * The parameter to set the title of the application.
     */
    @Parameter(names = {"--title", "-t"}, description = "Sets the title of the test game")
    private String gameTitle = "Test Game";

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<TestExecution> getExecution() {
        return TestExecution.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Module> getRequiredModules() {
        return Collections.singletonList(new TestSlickModule(this.gameTitle));
    }
}
