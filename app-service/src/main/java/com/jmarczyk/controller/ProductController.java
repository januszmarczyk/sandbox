package com.jmarczyk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmarczyk.data.Product;
import com.jmarczyk.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController
{
  private final ProductService service;

  @GetMapping
  public Flux<Product> all() {
    log.info( "Retrieving all products." );
    return service.getAll();
  }
}