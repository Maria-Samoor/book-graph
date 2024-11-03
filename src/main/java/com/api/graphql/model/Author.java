package com.api.graphql.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an author with an ID and a name.
 */
@Data
@NoArgsConstructor
@Document(collection = "author")
public class Author {

    @Id
    private Integer id; // The unique identifier for the author.

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name; // The name of the author.
}
