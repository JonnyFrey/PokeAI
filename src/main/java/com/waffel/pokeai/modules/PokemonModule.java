package com.waffel.pokeai.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.waffel.pokeai.Resources;
import com.waffel.pokeai.database.SqliteDao;
import com.waffel.pokeai.database.query.PokemonQuery;
import com.waffel.pokeai.dex.PokeDex;

import java.nio.file.Path;

import static com.waffel.pokeai.GameConstants.POKEDEX_PATH;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokemonModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Path.class)
                .annotatedWith(Names.named(POKEDEX_PATH))
                .toInstance(Resources.getSystemResource("pokedex/data/veekun-pokedex.sqlite"));
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
