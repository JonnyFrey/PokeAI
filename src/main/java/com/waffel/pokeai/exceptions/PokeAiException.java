package com.waffel.pokeai.exceptions;

/**
 * Represents when issues occur in the application
 */
@SuppressWarnings("unused")
public final class PokeAiException extends Exception {

    /**
     * Represents an exception caused by the PokeAi application
     *
     * @param message a meaningful message describing what the issue was
     */
    public PokeAiException(final String message) {
        super(message);
    }

    /**
     * Wraps an exception with a cause caused by the PokeAi application
     *
     * @param message a meaningful message describing what the issue was
     * @param cause   the original exception that was thrown
     */
    public PokeAiException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
