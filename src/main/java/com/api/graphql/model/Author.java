package com.api.graphql.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Represents an author with an ID and a name.
 *
 * @param id the unique identifier of the author.
 * @param name the name of the author.
 */
public record Author(Integer id,
                     String name) {

    /**
     * A static list of sample authors used for testing and demo purposes.
     */
    public static List<Author> authors = Arrays.asList(
            new Author(1,"author A"),
            new Author (2, "author B")
    );

    /**
     * Retrieves an author by their ID.
     *
     * @param id the ID of the author to retrieve.
     * @return an {@link Optional} containing the {@link Author} if found, otherwise empty.
     */
    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(author -> author.id.equals(id))
                .findFirst();
    }
}
