package com.api.graphql.repository;

import com.api.graphql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link Book} entity.
 * Provides methods to perform CRUD operations on the Book collection in MongoDB.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    /**
     * Finds all books by the given author ID.
     *
     * @param authorId the ID of the author whose books are to be retrieved.
     * @return a list of {@link Book} entities associated with the given author ID.
     */
    List<Book> findByAuthorId(Integer authorId);
}
