package com.waffel.pokeai.games;

import com.google.inject.Inject;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.examples.NiftyExample;
import de.lessvoid.nifty.slick2d.NiftyGame;

import javax.annotation.Nonnull;

/**
 * Created by Jonny on 7/5/2017.
 */
public class NiftyExampleGame extends NiftyGame {

    private final NiftyExample niftyExample;

    @Inject
    public NiftyExampleGame(@Nonnull NiftyExample niftyExample) {
        super(niftyExample.getTitle(), niftyExample.getStartScreen());
        this.niftyExample = niftyExample;
    }

    @Override
    protected void prepareNifty(@Nonnull Nifty nifty) {
        niftyExample.prepareStart(nifty);
        if (niftyExample.getMainXML() != null) {
            nifty.fromXml(niftyExample.getMainXML(), niftyExample.getStartScreen());
        }
    }
}
