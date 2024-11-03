package com.api.graphql.service;

import com.api.graphql.model.Author;

import java.util.List;

/**
 * Service interface for managing {@link Author} entities.
 * Provides methods for creating, retrieving, updating, and deleting authors.
 */
public interface AuthorService {
    /**
     * Creates a new author.
     *
     * @param author the author to be created.
     * @return the created {@link Author}.
     */
    Author createAuthor(Author author);

    /**
     * Retrieves an author by their ID.
     *
     * @param id the ID of the author to retrieve.
     * @return the {@link Author} associated with the given ID.
     */
    Author getAuthorById(Integer id);

    /**
     * Retrieves all authors.
     *
     * @return a list of all {@link Author} entities.
     */
    List<Author> getAllAuthors();

    /**
     * Updates an existing author.
     *
     * @param id the ID of the author to update.
     * @param authorDetails the updated author details.
     * @return the updated {@link Author}.
     */
    Author updateAuthor(Integer id, Author authorDetails);

    /**
     * Deletes an author by their ID.
     *
     * @param id the ID of the author to delete.
     */
    void deleteAuthor(Integer id);
}
