package com.waffel.pokeai;

import com.beust.jcommander.JCommander;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.waffel.pokeai.configuration.Configuration;
import com.waffel.pokeai.exceptions.PokeAiException;
import com.waffel.pokeai.exceptions.PokeAiRuntimeException;
import com.waffel.pokeai.execution.Command;
import com.waffel.pokeai.execution.Execution;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;
import java.util.Arrays;

import static com.waffel.pokeai.GameConstants.APP_NAME;

/**
 * Main entry point of the application.
 */
@Slf4j
@Getter
public final class Main {

    private final Execution execution;

    /**
     * Parses the CLI arguments and configures and builds a {@link Execution}
     *
     * @param args CLI arguments
     */
    Main(final String... args) {
        final MainParameters mainParameters = new MainParameters();
        final JCommander jCommander = new JCommander(mainParameters);
        jCommander.setProgramName(APP_NAME);

        Arrays.stream(Command.getCommands())
                .forEach(command -> jCommander.addCommand(command.getCommand(), command.getConfiguration()));

        jCommander.parse(args);

        final String commandName = jCommander.getParsedCommand();
        final Command command = Command.byName(commandName);

        if (mainParameters.isHelp()) {
            if (Command.DEFAULT.equals(command)) {
                jCommander.usage();
            } else {
                jCommander.usage(commandName);
            }
            throw new PokeAiRuntimeException("exiting...");
        }

        final Configuration<?> configuration = command.getConfiguration();
        final Injector injector = Guice.createInjector(configuration.getRequiredModules());
        this.execution = injector.getInstance(configuration.getExecution());
    }

    /**
     * Main entry point of the application
     *
     * @param args CLI arguments
     */
    public static void main(final String... args) {
        setupProperties();
        final Main main = new Main(args);
        try {
            main.getExecution().execute();
        } catch (PokeAiException e) {
            LOGGER.error("Failed to execute PokeAi", e);
        }
    }

    /**
     * Sets up System Properties in order for lwjgl to function. Tied to how natives are resolved within the
     * build.gradle
     */
    static void setupProperties() {
        final String libraryNatives = Paths.get("build/natives/").toFile().getAbsolutePath();
        System.setProperty("org.lwjgl.librarypath", libraryNatives);
        System.setProperty("net.java.games.input.librarypath", libraryNatives);
    }

}
