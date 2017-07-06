package com.waffel.pokeai.configuration;

import com.google.inject.Module;
import com.waffel.pokeai.execution.SlickExecution;
import com.waffel.pokeai.modules.NiftyExampleModule;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jonny on 7/5/2017.
 */
public class NiftyExampleConfiguration implements Configuration<SlickExecution> {
    @Override
    public Class<SlickExecution> getExecution() {
        return SlickExecution.class;
    }

    @Override
    public List<Module> getRequiredModules() {
        return Collections.singletonList(new NiftyExampleModule());
    }
}
