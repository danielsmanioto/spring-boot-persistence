package com.dsmanioto.persistencejpamongo.repository;

import com.dsmanioto.persistencejpamongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {}
