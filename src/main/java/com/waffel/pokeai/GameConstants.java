package com.waffel.pokeai;

import com.google.inject.name.Named;

/**
 * Pure class to hold basic static constants that don't change.
 */
public final class GameConstants {

    private GameConstants() {
    }

    /**
     * The name for a {@link Named} annotation that represents a Game Title
     */
    public static final String GAME_TITLE = "GAME_TITLE";

    public static final String POKEDEX_PATH = "POKEDEX_PATH";

    /**
     * A place holder exception that is used for when code isn't done
     */
    public static final RuntimeException INCOMPLETE_EXCEPTION = new UnsupportedOperationException(
            "Code not implemented, try out `test` command"
    );

    /**
     * A test example width of a {@link org.newdawn.slick.GameContainer}
     */
    public static final int TEST_GAME_WIDTH = 640;

    /**
     * A test example height of a {@link org.newdawn.slick.GameContainer}
     */
    public static final int TEST_GAME_HEIGHT = 480;

    /**
     * Name of the application
     */
    public static final String APP_NAME = "PokeAi";

}
