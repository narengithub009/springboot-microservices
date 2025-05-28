package com.java.microservices.product.repository;

import com.java.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
// The @Repository annotation indicates that this interface is a Spring Data repository.
public interface ProductRepository extends MongoRepository<Product, String> {

}
// This interface extends MongoRepository, which provides CRUD operations for the Product entity.
// The first generic parameter is the entity type (Product), and the second is the type of the entity's ID (String).
// It allows us to perform operations like saving, deleting, and finding products in the MongoDB database.