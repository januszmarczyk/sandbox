package com.jmarczyk.service;

import org.springframework.stereotype.Service;

import com.jmarczyk.dao.ProductRepository;
import com.jmarczyk.data.Product;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductService
{
  private final ProductRepository repository;

  public Flux<Product> getAll() {
    return repository.findAll();
  }
}