package com.api.graphql.service;

import com.api.graphql.model.Book;

import java.util.List;

/**
 * Service interface for managing {@link Book} entities.
 * Provides methods for creating, retrieving, updating, and deleting books.
 */
public interface BookService {
    /**
     * Creates a new book.
     *
     * @param book the book to be created.
     * @return the created {@link Book}.
     */
    Book createBook(Book book);

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve.
     * @return the {@link Book} associated with the given ID.
     */
    Book getBookById(Integer id);

    /**
     * Retrieves all books.
     *
     * @return a list of all {@link Book} entities.
     */
    List<Book> getAllBooks();

    /**
     * Updates an existing book.
     *
     * @param id the ID of the book to update.
     * @param bookDetails the updated book details.
     * @return the updated {@link Book}.
     */
    Book updateBook(Integer id, Book bookDetails);

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete.
     */
    void deleteBook(Integer id);

    /**
     * Retrieves all books by a specific author ID.
     *
     * @param authorId the ID of the author whose books are to be retrieved.
     * @return a list of {@link Book} entities associated with the given author ID.
     */
    List<Book> getBooksByAuthorId(Integer authorId);
}