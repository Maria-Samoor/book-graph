# GraphQL Book API

This is a simple GraphQL API built using Spring Boot, providing data on books and authors. The project uses an in-memory data structure for demonstration and testing purposes.


## Features

- Fetch a list of all books.
- Fetch a single book by its ID.
- Fetch the author associated with a given book.

## Technologies

- **Java**: Main programming language
- **Spring Boot**: Framework for building and testing the API
- **Spring GraphQL**: Library for building GraphQL APIs in Spring
- **JUnit**: Testing framework

## Project Structure

- **BookController**: Manages GraphQL queries related to books.
- **Book**: Represents a book object, including an in-memory list of books.
- **Author**: Represents an author object, including an in-memory list of authors.
- **BookControllerTest**: Unit tests for BookController.

### Running the Application

After building, you can start the application with:

./gradlew bootRun

### Accessing the GraphQL API

The GraphQL API can be accessed at:
http://localhost:8080/graphql
