package com.api.graphql.model;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Represents a book with an ID, name, page count, and author ID.
 *
 * @param id the unique identifier of the book.
 * @param name the name of the book.
 * @param pageCount the number of pages in the book.
 * @param authorId the ID of the author of the book.
 */
public record Book(Integer id,
                   String name,
                   Integer pageCount,
                   Integer authorId) {

    /**
     * A static list of sample books used for testing and demo purposes.
     */
    public static List<Book> books = Arrays.asList(
            new Book(1,"1st Book",200,1),
            new Book (2,"2nd Book", 400,2)

    );

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve.
     * @return an {@link Optional} containing the {@link Book} if found, otherwise empty.
     */
    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(book -> book.id.equals(id))
                .findFirst();
    }
}

