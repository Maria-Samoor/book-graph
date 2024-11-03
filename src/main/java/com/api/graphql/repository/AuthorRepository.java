package com.api.graphql.repository;


import com.api.graphql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Author} entity.
 * Provides methods to perform CRUD operations on the Author collection in MongoDB.
 */
@Repository
public interface AuthorRepository extends MongoRepository<Author, Integer> {
}

