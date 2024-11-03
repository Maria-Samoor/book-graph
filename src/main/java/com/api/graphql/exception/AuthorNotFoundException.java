package com.api.graphql.exception;

/**
 * Exception thrown when an author is not found in the system.
 */
public class AuthorNotFoundException extends RuntimeException {

    /**
     * Constructs a new AuthorNotFoundException with the specified detail message.
     *
     * @param id the ID of the author that was not found
     */
    public AuthorNotFoundException(Integer id) {
        super("Author not found with ID: " + id);    }
}
