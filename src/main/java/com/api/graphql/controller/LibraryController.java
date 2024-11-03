package com.api.graphql.controller;

import com.api.graphql.exception.AuthorNotFoundException;
import com.api.graphql.exception.BookNotFoundException;
import com.api.graphql.model.Author;
import com.api.graphql.model.Book;
import com.api.graphql.service.AuthorService;
import com.api.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

/**
 * Controller for handling GraphQL requests related to authors and books.
 * Provides query and mutation mappings for managing authors and books.
 */
@Controller
public class LibraryController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    /**
     * Retrieves all authors from the system.
     *
     * @return a list of all authors
     */
    @QueryMapping
    public List<Author> authors() {
        return authorService.getAllAuthors();
    }

    /**
     * Retrieves an author by their ID.
     *
     * @param id the ID of the author to retrieve
     * @return the author with the specified ID
     */
    @QueryMapping
    public Author authorById(@Argument Integer id) {
        try {
            return authorService.getAuthorById(id);
        } catch (AuthorNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Creates a new author in the system.
     *
     * @param author the author to be created
     * @return the created author
     */
    @MutationMapping
    public Author createAuthor(@Argument Author author) {
        return authorService.createAuthor(author);
    }

    /**
     * Updates an existing author with the specified ID.
     *
     * @param id the ID of the author to update
     * @param authorDetails the new details for the author
     * @return the updated author
     */
    @MutationMapping
    public Author updateAuthor(@Argument Integer id, @Argument Author authorDetails) {
        try {
            return authorService.updateAuthor(id, authorDetails);
        } catch (AuthorNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Deletes an author by their ID.
     *
     * @param id the ID of the author to delete
     */
    @MutationMapping
    public void deleteAuthor(@Argument Integer id) {
        try {
            authorService.deleteAuthor(id);
        } catch (AuthorNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Retrieves all books from the system.
     *
     * @return a list of all books
     */
    @QueryMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return the book with the specified ID
     */
    @QueryMapping
    public Book bookById(@Argument Integer id) {
        try {
            return bookService.getBookById(id);
        } catch (BookNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Retrieves all books written by a specific author.
     *
     * @param authorId the ID of the author whose books are to be retrieved
     * @return a list of books written by the specified author
     */
    @QueryMapping
    public List<Book> booksByAuthorId(@Argument Integer authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    /**
     * Creates a new book in the system.
     *
     * @param book the book to be created
     * @return the created book
     */
    @MutationMapping
    public Book createBook(@Argument Book book) {
        return bookService.createBook(book);
    }

    /**
     * Updates an existing book with the specified ID.
     *
     * @param id the ID of the book to update
     * @param bookDetails the new details for the book
     * @return the updated book
     */
    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument Book bookDetails) {
        try {
            return bookService.updateBook(id, bookDetails);
        } catch (BookNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     */
    @MutationMapping
    public void deleteBook(@Argument Integer id) {
        try {
            bookService.deleteBook(id);
        } catch (BookNotFoundException ex) {
            // Handle the exception or log it if necessary
            throw ex; // Let the GlobalExceptionHandler take care of it
        }
    }

    /**
     * Resolves the author for a given book.
     *
     * @param book the book for which the author is to be retrieved
     * @return the author of the specified book
     */
    @SchemaMapping(typeName = "Book", field = "author")
    public Author getAuthor(Book book) {
        return authorService.getAuthorById(book.getAuthorId());
    }
}
