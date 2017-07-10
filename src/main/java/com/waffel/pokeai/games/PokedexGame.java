package com.waffel.pokeai.games;

import com.google.inject.Inject;
import com.waffel.pokeai.dex.PokeDex;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.slick2d.NiftyOverlayGame;
import lombok.AllArgsConstructor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import javax.annotation.Nonnull;

/**
 * Created by Jonny on 7/3/2017.
 */
@AllArgsConstructor(onConstructor = @__(@Inject))
public class PokedexGame extends NiftyOverlayGame {

    public final PokeDex pokeDex;

    @Override
    protected void initGameAndGUI(@Nonnull GameContainer container) {
        this.initNifty(container);
    }

    @Override
    protected void renderGame(@Nonnull GameContainer container, @Nonnull Graphics g) {
        g.clear();
    }

    @Override
    protected void updateGame(@Nonnull GameContainer container, int delta) {

    }

    @Override
    protected void prepareNifty(@Nonnull Nifty nifty) {
        nifty.fromXml("nifty/pokedex.xml", "start");

    }

    @Override
    public boolean closeRequested() {
        return true;
    }

    @Override
    public String getTitle() {
        return "Pokedex";
    }
}
