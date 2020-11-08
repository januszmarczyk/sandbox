package com.jmarczyk.config;

import com.jmarczyk.data.MetricType;
import com.jmarczyk.data.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductLoaderTemp {
  private final ReactiveRedisConnectionFactory factory;
  private final ReactiveRedisOperations<String, Product> productOps;

  @PostConstruct
  public void loadData() {
    factory
        .getReactiveConnection()
        .serverCommands()
        .flushAll()
        .thenMany(
            Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
                .map(
                    name ->
                        new Product(
                            UUID.randomUUID().toString(), name, "desc", MetricType.UNDEFINED, 0))
                .flatMap(product -> productOps.opsForValue().set(product.getId(), product)))
        .thenMany(productOps.keys("*").flatMap(productOps.opsForValue()::get))
        .subscribe(System.out::println);
  }
}
