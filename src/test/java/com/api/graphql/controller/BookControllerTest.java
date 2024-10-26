package com.api.graphql.controller;

import com.api.graphql.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

/**
 * Unit test for {@link BookController}.
 */
@GraphQlTest(BookController.class)
class BookControllerTest {
    @Autowired
    private GraphQlTester graphQlTester; // GraphQL tester for executing queries in tests

    /**
     * Test to ensure that the books query returns the expected number of books.
     */
    @Test
    void canGetBooks() {
        graphQlTester
                .documentName("books")
                .execute()
                .path("books")
                .entityList(Book.class)
                .hasSize(2);
    }
}