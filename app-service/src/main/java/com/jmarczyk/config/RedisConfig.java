package com.jmarczyk.config;

import com.jmarczyk.data.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  @Bean
  ReactiveRedisOperations<String, Product> redisProductOperations(ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<Product> productSerializer = new Jackson2JsonRedisSerializer<>(Product.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Product> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, Product> context = builder.value(productSerializer).build();

    return new ReactiveRedisTemplate<>(factory, context);
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate() {
    return new RedisTemplate<byte[], byte[]>();
  }
}