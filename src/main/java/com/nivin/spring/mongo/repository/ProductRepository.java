package com.nivin.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nivin.spring.mongo.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
