package com.waffel.pokeai.execution;

import com.waffel.pokeai.configuration.Configuration;
import com.waffel.pokeai.configuration.MainConfiguration;
import com.waffel.pokeai.configuration.PokedexConfiguration;
import com.waffel.pokeai.configuration.TestConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * This represents the cli command and it's associated commands
 */
@AllArgsConstructor
@Getter
public enum Command {

    /**
     * No Command To Be executed, starts normal execution
     */
    DEFAULT("", new MainConfiguration()),

    /**
     * Test command that runs and checks to see if slick is appropriately set up
     */
    TEST("test", new TestConfiguration()),

    /**
     * See pokedex information
     */
    POKEDEX("pokedex", new PokedexConfiguration());

    private final String command;
    private final Configuration<? extends Execution> configuration;

    /**
     * Returns the matching {@link Command} by name. If no {@link Command} was found, the DEFAULT {@link Command} will be returned.
     *
     * @param name the name of the {@link Command}
     * @return the matching {@link Command}
     */
    public static Command byName(final String name) {
        for (Command command : Command.getCommands()) {
            if (command.getCommand().equals(name)) {
                return command;
            }
        }
        return DEFAULT;
    }

    /**
     * Returns an array of all valid commands
     *
     * @return an array of valid commands
     */
    public static Command[] getCommands() {
        return Arrays.stream(Command.values())
                .filter(command -> !DEFAULT.equals(command))
                .toArray(Command[]::new);
    }

}
