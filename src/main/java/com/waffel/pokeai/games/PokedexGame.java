package com.waffel.pokeai.games;

import com.google.common.collect.Lists;
import com.waffel.pokeai.dex.PokeDex;
import com.waffel.pokeai.models.pokemon.Pokemon;
import com.waffel.pokeai.views.PokemonImage;
import com.waffel.pokeai.views.PokemonView;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.slick2d.NiftyOverlayGame;
import org.newdawn.slick.*;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.newdawn.slick.Input.KEY_EQUALS;
import static org.newdawn.slick.Input.KEY_MINUS;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokedexGame extends NiftyOverlayGame {

    @Override
    protected void initGameAndGUI(@Nonnull GameContainer container) {

    }

    @Override
    protected void renderGame(@Nonnull GameContainer container, @Nonnull Graphics g) {

    }

    @Override
    protected void updateGame(@Nonnull GameContainer container, int delta) {

    }

    @Override
    protected void prepareNifty(@Nonnull Nifty nifty) {

    }

    @Override
    public boolean closeRequested() {
        return false;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
