package com.waffel.pokeai.dex;

import com.google.common.collect.Lists;
import com.waffel.pokeai.models.pokemon.Pokemon;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PokeDex extends AbstractDex<Pokemon> {
    @Inject
    public PokeDex(Collection<Pokemon> pokemons) {
        super(pokemons);
    }

    public Pokemon getRandomPokemon() {
        final List<Integer> ids = Lists.newArrayList(this.register.keySet());
        Collections.shuffle(ids);
        if (ids.size() > 0) {
            return this.searchById(ids.get(0));
        }
        return null;
    }

}
