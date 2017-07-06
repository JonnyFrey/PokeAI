package com.waffel.pokeai.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.waffel.pokeai.database.SqliteDao;
import com.waffel.pokeai.database.query.PokemonQuery;
import com.waffel.pokeai.dex.PokeDex;
import com.waffel.pokeai.games.PokedexGame;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.waffel.pokeai.GameConstants.*;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokemonModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Path.class)
                .annotatedWith(Names.named(POKEDEX_PATH))
                .toInstance(Paths.get("pokedex/data/veekun-pokedex.sqlite"));
        this.install(
                new SlickModule<>(
                        "Pokedex",
                        PokedexGame.class,
                        TEST_GAME_WIDTH,
                        TEST_GAME_HEIGHT
                )
        );
    }

    @Provides
    @Singleton
    public PokeDex providePokeDex(
            final SqliteDao dao,
            final PokemonQuery pokemonQuery
    ) {
        return new PokeDex(dao.getObjectsBySearch(pokemonQuery));
    }

}
