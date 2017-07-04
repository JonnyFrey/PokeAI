package com.waffel.pokeai.views;

import com.waffel.pokeai.models.pokemon.Pokemon;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokemonView {

    private final Map<Integer, Animation> pokemonImageMap;
    private final float x;
    private final float y;
    private final Dimension dimension;

    public PokemonView(final float x, final float y, final Dimension dimension) {
        this.x = x;
        this.y = y;
        this.dimension = dimension;
        this.pokemonImageMap = new HashMap<>();
    }

    public void drawPokemon(final Graphics g, final Pokemon pokemon) {
        g.drawAnimation(this.pokemonImageMap.get(pokemon.getId()), this.x, this.y);
    }

}
