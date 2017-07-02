package com.waffel.pokeai;

import com.waffel.pokeai.exceptions.PokeAiException;
import com.waffel.pokeai.execution.Execution;
import com.waffel.pokeai.execution.TestExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Main.class)
public class MainTest {
    @Test
    public void testMainExecuteCalled() throws Exception {
        final String[] mockArgs = new String[]{"mockArgs"};
        final Main mainMock = mock(Main.class);
        final Execution executionMock = mock(Execution.class);

        whenNew(Main.class).withAnyArguments().thenReturn(mainMock);
        when(mainMock.getExecution()).thenReturn(executionMock);

        Main.main(mockArgs);
        verify(executionMock).execute();
    }

    @Test
    public void testMainExecuteFailedExceptionCaught() throws Exception {
        final String[] mockArgs = new String[]{"mockArgs"};
        final Main mainMock = mock(Main.class);
        final Execution executionMock = mock(Execution.class);

        whenNew(Main.class).withAnyArguments().thenReturn(mainMock);
        when(mainMock.getExecution()).thenReturn(executionMock);
        doThrow(PokeAiException.class).when(executionMock).execute();

        Main.main(mockArgs);
    }

    @Test
    public void testMainGetAppropriateExecution() throws Exception {
        Main.setupProperties();
        final Main main = new Main("test");
        assertTrue(main.getExecution() instanceof TestExecution);
    }

}