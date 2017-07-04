package com.waffel.pokeai.dex;

import com.waffel.pokeai.models.pokemon.Classified;

import java.util.Collection;

/**
 * Created by Jonny on 7/3/2017.
 */
public interface Dex<T extends Classified> {

    T searchById(final Integer id);

    T searchByName(final String name);

    Collection<T> getAllEntities();

}
