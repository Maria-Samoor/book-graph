package com.api.graphql.controller;

import com.api.graphql.model.Author;
import com.api.graphql.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling GraphQL queries related to books.
 */
@Controller
public class BookController {

    /**
     * Retrieves a list of all books.
     *
     * @return a list of {@link Book} objects.
     */
    @QueryMapping
    public List<Book> books(){
        return Book.books;
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve.
     * @return an {@link Optional} containing the {@link Book} if found, otherwise empty.
     */
    @QueryMapping
    public Optional<Book> bookById(@Argument Integer id){
        return Book.getBookById(id);
    }

    /**
     * Retrieves the author of a given book.
     *
     * @param book the book for which to retrieve the author.
     * @return an {@link Optional} containing the {@link Author} if found, otherwise empty.
     */
    @SchemaMapping
    public Optional<Author> author(Book book){
        return Author.getAuthorById(book.authorId());
    }
}
