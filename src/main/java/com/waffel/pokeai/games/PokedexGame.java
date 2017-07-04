package com.waffel.pokeai.games;

import com.google.common.collect.Ordering;
import com.waffel.pokeai.dex.PokeDex;
import com.waffel.pokeai.models.pokemon.Pokemon;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokedexGame extends BasicGame {

    private final List<Pokemon> pokemonList;

    /**
     * Create a new basic game
     *
     * @param title The title for the game
     */
    public PokedexGame(
            final PokeDex pokeDex,
            final
    ) {
        super("Pokedex");
        this.pokemonList = this.pokeDex.getAllEntities();
        Collections.sort(this.pokemonList);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        container.setShowFPS(false);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {

    }
}
