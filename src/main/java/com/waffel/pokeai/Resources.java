package com.waffel.pokeai;

import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jonny on 7/3/2017.
 */
@Slf4j
public final class Resources {

    private Resources() {
    }

    public static Path getSystemResource(final String path) {
        try {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        } catch (URISyntaxException e) {
            LOGGER.error("Failed to find file " + path);
            return null;
        }
    }

}
