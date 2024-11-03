package com.api.graphql.service.impl;

import com.api.graphql.exception.BookNotFoundException;
import com.api.graphql.model.Book;
import com.api.graphql.repository.BookRepository;
import com.api.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link BookService} interface.
 * Provides methods for managing books in the system.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Integer id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (bookDetails.getAuthorId() != null) {
            book.setAuthorId(bookDetails.getAuthorId());
        }
        book.setName(bookDetails.getName());
        book.setPageCount(bookDetails.getPageCount());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorId(authorId);
    }
}
