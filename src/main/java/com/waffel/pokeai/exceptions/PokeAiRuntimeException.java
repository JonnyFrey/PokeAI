package com.waffel.pokeai.exceptions;

/**
 * Represents when issues occur in the application that should not be checked.
 */
@SuppressWarnings("unused")
public final class PokeAiRuntimeException extends RuntimeException {

    /**
     * Represents a runtime exception caused by the PokeAi application
     *
     * @param message a meaningful message describing what the issue was
     */
    public PokeAiRuntimeException(final String message) {
        super(message);
    }

    /**
     * Wraps an exception with a cause caused by the PokeAi application
     *
     * @param message a meaningful message describing what the issue was
     * @param cause   the original exception that was thrown
     */
    public PokeAiRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
