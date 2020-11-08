package com.jmarczyk.controller;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmarczyk.data.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ReactiveRedisOperations<String, Product> productOperations;

  @GetMapping("/products")
  public Flux<Product> all() {
    log.info( "Retrieving all products." );
    return productOperations.keys("*").flatMap(productOperations.opsForValue()::get);
  }
}
