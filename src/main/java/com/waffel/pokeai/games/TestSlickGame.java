package com.waffel.pokeai.games;

import com.google.inject.Inject;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * A Hello World Basic Game to test if slick2D configurations are correctly implemented.
 */
public final class TestSlickGame extends BasicGame {

    /**
     * Create a new basic game
     *
     * @param title The title for the game
     */
    @Inject
    public TestSlickGame(final String title) {
        super(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final GameContainer container) throws SlickException {
        //no need setup required
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        //no update needed
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        final String message = "Slick Successfully installed";

        final int x = container.getWidth() / 2 - (g.getFont().getWidth(message) / 2);
        final int y = container.getHeight() / 2 - (g.getFont().getHeight(message) / 2);
        g.drawString(message, x, y);
    }
}
