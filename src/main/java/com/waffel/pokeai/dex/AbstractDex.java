package com.waffel.pokeai.dex;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.waffel.pokeai.models.pokemon.Classified;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Jonny on 7/3/2017.
 */
public class AbstractDex<T extends Classified> implements Dex<T> {

    protected final BiMap<Integer, String> identifierRegister;
    protected final Map<Integer, T> register;

    public AbstractDex(final Collection<T> entities) {
        this.identifierRegister = HashBiMap.create(
                entities
                        .parallelStream()
                        .collect(toMap(Classified::getId, Classified::getName))
        );
        this.register = entities
                .parallelStream()
                .collect(toMap(Classified::getId, Function.identity()));
    }

    @Override
    public T searchById(final Integer id) {
        if (identifierRegister.containsKey(id)) {
            return register.get(id);
        }
        return null;
    }

    @Override
    public T searchByName(String name) {
        if (identifierRegister.inverse().containsKey(name)) {
            final Integer id = identifierRegister.inverse().get(name);
            return register.get(id);
        }
        return null;
    }

    @Override
    public Collection<T> getAllEntities() {
        return register.values();
    }
}
