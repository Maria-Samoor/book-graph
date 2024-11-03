package com.api.graphql.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a book with an ID, name, page count, and author ID.
 */
@Data
@NoArgsConstructor
@Document(collection = "book")
public class Book {

    @Id
    private Integer id; // The unique identifier for the book.

    @NotBlank(message = "Book name is required")
    @Size(min = 2, max = 200, message = "Book name must be between 2 and 200 characters")
    private String name; // The name of the book.

    @NotNull(message = "Page count is required")
    @Min(value = 1, message = "Page count must be greater than 0")
    private Integer pageCount; // The number of pages in the book.

    @NotNull(message = "Author ID is required")
    private Integer authorId; // The ID of the author of the book.
}