package com.waffel.pokeai.modules;

import com.google.inject.AbstractModule;
import com.waffel.pokeai.games.NiftyExampleGame;
import de.lessvoid.nifty.examples.NiftyExample;
import de.lessvoid.nifty.examples.all.AllExamples;
import de.lessvoid.nifty.examples.defaultcontrols.ControlsDemo;

/**
 * Created by Jonny on 7/5/2017.
 */
public class NiftyExampleModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(NiftyExample.class).to(ControlsDemo.class);
        this.install(
                new SlickModule<>(
                        "NiftyExample",
                        NiftyExampleGame.class,
                        1024,
                        768
                )
        );
    }
}
