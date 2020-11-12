package com.jmarczyk.service;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.jmarczyk.dao.ProductRepository;
import com.jmarczyk.util.MockitoExtension;

import reactor.core.publisher.Flux;

@MockitoExtension
class ProductServiceTest {

  private ProductService productService;
  @Mock private ProductRepository repositoryMock;

  @BeforeEach
  void setUp() {
    productService = new ProductService(repositoryMock);
  }

  @Test
  void testGetAll() {
    when(repositoryMock.findAll()).thenReturn(Flux.empty());

    Assertions.assertThat(productService.getAll()).isSameAs(Flux.empty());
  }
}
