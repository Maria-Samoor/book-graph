package com.api.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 * Handles exceptions thrown within the application and converts them into GraphQL errors.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles AuthorNotFoundException and converts it to a GraphQL error.
     *
     * @param ex the exception to handle
     * @return a GraphQLError with a NOT_FOUND error type
     */
    @ExceptionHandler(AuthorNotFoundException.class)
    public GraphQLError handleAuthorNotFoundException(AuthorNotFoundException ex) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .build();
    }

    /**
     * Handles BookNotFoundException and converts it to a GraphQL error.
     *
     * @param ex the exception to handle
     * @return a GraphQLError with a NOT_FOUND error type
     */
    @ExceptionHandler(BookNotFoundException.class)
    public GraphQLError handleBookNotFoundException(BookNotFoundException ex) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.NOT_FOUND)
                .build();
    }
}
