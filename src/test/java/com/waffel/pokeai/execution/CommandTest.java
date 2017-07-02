package com.waffel.pokeai.execution;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CommandTest {
    @Test
    public void byName() throws Exception {
        assertEquals(Command.DEFAULT, Command.byName(null));
        assertEquals(Command.DEFAULT, Command.byName(""));
        assertEquals(Command.DEFAULT, Command.byName("garbage"));
        assertEquals(Command.TEST, Command.byName("test"));
    }

    @Test
    public void testGetCommandsContainsNoDefault() throws Exception {
        Set<Command> commandSet = Sets.newHashSet(Command.getCommands());
        assertFalse(commandSet.contains(Command.DEFAULT));
    }

}