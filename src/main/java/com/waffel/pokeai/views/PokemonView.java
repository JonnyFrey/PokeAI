package com.waffel.pokeai.views;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.waffel.pokeai.exceptions.PokeAiRuntimeException;

import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jonny on 7/3/2017.
 */
public class PokemonView {

    private LoadingCache<Integer, PokemonImage> imageCache;

    public PokemonView(final Path mainPath) {
        this.imageCache = CacheBuilder.newBuilder()
                .maximumSize(800 * 2)
                .build(
                        new CacheLoader<Integer, PokemonImage>() {
                            @Override
                            public PokemonImage load(final Integer key) throws Exception {
                                return new PokemonImage(mainPath, key + ".png", 2);
                            }
                        }
                );
    }

    public PokemonImage getPokemonAnimation(int id) {
        try {
            return this.imageCache.get(id);
        } catch (ExecutionException e) {
            throw new PokeAiRuntimeException("Failed to get Pokemon Animation", e);
        }
    }

}
