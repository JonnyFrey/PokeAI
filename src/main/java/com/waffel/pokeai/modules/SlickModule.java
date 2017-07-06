package com.waffel.pokeai.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.waffel.pokeai.GameConstants;
import com.waffel.pokeai.games.TestSlickGame;
import lombok.AllArgsConstructor;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.SlickException;

import static com.waffel.pokeai.GameConstants.TEST_GAME_HEIGHT;
import static com.waffel.pokeai.GameConstants.TEST_GAME_WIDTH;

/**
 * A Module describing how to create a test game
 */
@AllArgsConstructor
public final class SlickModule<T extends Game> extends AbstractModule {

    private final String gameTitle;

    private final Class<T> gameClass;

    private final int gameWidth;

    private final int gameHeight;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        this.bindConstant().annotatedWith(Names.named(GameConstants.GAME_TITLE)).to(gameTitle);
        this.bind(Game.class).to(gameClass).asEagerSingleton();
    }

    @Provides
    public AppGameContainer providesGameContainer(final Game game) throws SlickException {
        final AppGameContainer container = new AppGameContainer(game);
        container.setDisplayMode(gameWidth, gameHeight, false);
        container.setShowFPS(false);
        return container;
    }

}
