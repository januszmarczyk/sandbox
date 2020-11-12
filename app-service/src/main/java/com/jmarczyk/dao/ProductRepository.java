package com.jmarczyk.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.jmarczyk.data.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {}