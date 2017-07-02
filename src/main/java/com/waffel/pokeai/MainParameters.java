package com.waffel.pokeai;

import com.beust.jcommander.Parameter;
import lombok.Getter;

/**
 * Small parameter class used for if the application as a whole
 */
@Getter
class MainParameters {

    @Parameter(names = "--help", description = "displays commands and it's description", help = true)
    private boolean help;

}
