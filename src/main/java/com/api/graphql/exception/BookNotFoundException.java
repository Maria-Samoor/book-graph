package com.api.graphql.exception;

/**
 * Exception thrown when a book is not found in the system.
 */
public class BookNotFoundException extends RuntimeException {
    /**
     * Constructs a new BookNotFoundException with the specified detail message.
     *
     * @param id the ID of the book that was not found
     */
    public BookNotFoundException(Integer id) {
        super("Book not found with ID: " + id);
    }
}
