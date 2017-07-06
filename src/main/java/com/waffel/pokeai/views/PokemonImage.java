package com.waffel.pokeai.views;

import com.waffel.pokeai.exceptions.PokeAiRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by Jonny on 7/4/2017.
 */
@Slf4j
public class PokemonImage {

    private static final String BACK_IMAGE_LOCATION = "back";
    private static final String FEMALE_IMAGE_LOCATION = "female";
    private static final String SECOND_FRAME_IMAGE_LOCATION = "frame2";
    private static final String SHINY_IMAGE_LOCATION = "shiny";

    private Animation frontMaleAnimation;
    private Animation backMaleAnimation;

    private Animation frontFemaleAnimation;
    private Animation backFemaleAnimation;

    private Animation shinyMaleFrontAnimation;
    private Animation shinyMaleBackAnimation;

    private Animation shinyFemaleFrontAnimation;
    private Animation shinyFemaleBackAnimation;

    public PokemonImage(final Path path, final String id, final int duration) {
        final Path backPath = path.resolve(BACK_IMAGE_LOCATION);

        final Path femalePath = path.resolve(FEMALE_IMAGE_LOCATION);
        final Path backFemalePath = backPath.resolve(FEMALE_IMAGE_LOCATION);

        final Path shinyPath = path.resolve(SHINY_IMAGE_LOCATION);
        final Path backShinyPath = backPath.resolve(SHINY_IMAGE_LOCATION);

        final Path shinyFemalePath = shinyPath.resolve(FEMALE_IMAGE_LOCATION);
        final Path shinyFemaleBackPath = backShinyPath.resolve(FEMALE_IMAGE_LOCATION);

        final Path secondFrontPath = path.resolve(SECOND_FRAME_IMAGE_LOCATION);
        final Path secondFemaleFrontPath = path.resolve(SECOND_FRAME_IMAGE_LOCATION);
        final Path secondShinyFrontPath = shinyPath.resolve(SECOND_FRAME_IMAGE_LOCATION);
        final Path secondShinyFemaleFrontPath = shinyFemalePath.resolve(SECOND_FRAME_IMAGE_LOCATION);

        this.frontMaleAnimation = mergeImages(path, secondFrontPath, id, duration);

        if (this.frontMaleAnimation == null) {
            this.frontMaleAnimation = new Animation();
//            throw new PokeAiRuntimeException("Couldn't find original image " + path.resolve(id));
        }

        this.backMaleAnimation = mergeImages(backPath, null, id, duration);

        this.frontFemaleAnimation = mergeImages(femalePath, secondFemaleFrontPath, id, duration);
        this.backFemaleAnimation = mergeImages(backFemalePath, null, id, duration);

        this.shinyMaleFrontAnimation = mergeImages(shinyPath, secondShinyFrontPath, id, duration);
        this.shinyMaleBackAnimation = mergeImages(backShinyPath, null, id, duration);

        this.shinyFemaleFrontAnimation = mergeImages(shinyFemalePath, secondShinyFemaleFrontPath, id, duration);
        this.shinyFemaleBackAnimation = mergeImages(shinyFemaleBackPath, null, id, duration);
    }

    private static Animation mergeImages(
            final Path first,
            final Path last,
            final String id,
            final int duration
    ) {
        final Path firstImagePath = first != null ? first.resolve(id) : null;
        final Path secondImagePath = last != null ? last.resolve(id) : null;

        final Image[] images = Stream.of(firstImagePath, secondImagePath)
                .filter(Objects::nonNull)
                .filter(PokemonImage::pathExists)
                .map(PokemonImage::resolveImage)
                .toArray(Image[]::new);

        if (images.length > 0) {
            return new Animation(images, duration);
        } else {
            LOGGER.debug(String.format("Did not find path for %s:[%s, %s]", id, first, last));
            return null;
        }
    }


    private static Image resolveImage(final Path path) {
        final File file = path.toFile();
        try {
            return new Image(new FileInputStream(file), file.getName(), false);
        } catch (final Exception e) {
            throw new PokeAiRuntimeException("Failed to load file " + file, e);
        }
    }

    private static boolean pathExists(final Path path) {
        return path.toFile().exists();
    }

    public Animation getMaleFront(final boolean shiny) {
        if (shiny) {
            return this.shinyMaleFrontAnimation != null ? this.shinyMaleFrontAnimation : this.frontMaleAnimation;
        } else {
            return this.frontMaleAnimation;
        }
    }

    public Animation getFemaleFront(final boolean shiny) {
        if (shiny) {
            return this.shinyFemaleFrontAnimation != null ? this.shinyMaleFrontAnimation : this.getFemaleFront(false);
        } else {
            return this.frontFemaleAnimation != null ? this.frontFemaleAnimation : this.getMaleFront(false);
        }
    }

    public Animation getMaleBack(final boolean shiny) {
        if (shiny) {
            return this.shinyMaleBackAnimation != null ? this.shinyMaleBackAnimation : this.getMaleFront(true);
        } else {
            return this.backMaleAnimation != null ? this.backMaleAnimation : this.getMaleFront(false);
        }
    }

    public Animation getFemaleBack(boolean shiny) {
        if (shiny) {
            return this.shinyFemaleBackAnimation != null ? this.shinyFemaleBackAnimation : this.getFemaleFront(true);
        } else {
            return this.backFemaleAnimation != null ? this.backFemaleAnimation : this.getFemaleFront(false);
        }
    }

}
